package com.baranchik.controller;

import com.baranchik.composits.Wrapper;
import com.baranchik.facade.ClientFacade;
import com.baranchik.model.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.servlet.ModelAndView;


@Controller
@SessionAttributes({"user", "wrapper", "orderClient"})
public class ClientController {

    @Autowired
    private ClientFacade clientFacade;

    @RequestMapping(value = "/view", method = RequestMethod.GET)
    public ModelAndView main() {
        ModelAndView modelAndView = new ModelAndView();
        Wrapper wrapper = clientFacade.getWrapper();
        modelAndView.addObject("wrapper", wrapper);
        modelAndView.setViewName("mainview");
        return modelAndView;
    }

    @RequestMapping(value = "/auth", method = RequestMethod.GET)
    public ModelAndView auth() {
        ModelAndView modelAndView = new ModelAndView();
        User user = new User();
        modelAndView.addObject("user", user);
        modelAndView.setViewName("auth");
        return modelAndView;
    }

    @RequestMapping(value = "/edit", method = RequestMethod.GET)
    public String edit(@ModelAttribute("user") User user, Model m) {
//        m.addAttribute("user", user);
        return "edit";
    }

    @RequestMapping(value = "/edit", method = RequestMethod.POST)
    public String update(@ModelAttribute("user") User user, Model m) {
        clientFacade.updateClient(user);
        return "redirect:/view";
    }

    @RequestMapping(value = "/exit", method = RequestMethod.GET)
    public String exit(SessionStatus sessionStatus) {
        sessionStatus.setComplete();
        return "redirect:/auth";

    }

    @RequestMapping(value = "/register", method = RequestMethod.GET)
    public String register(Model model) {
        model.addAttribute("newUser", clientFacade.getUserForRegister());
        return "register";
    }

    @RequestMapping(value = "/register", method = RequestMethod.POST)
    public String registerUser(@ModelAttribute("newUser") User user) {
        if (clientFacade.getUserByLogin(user.getLogin()) == null) {
            boolean addCoords = clientFacade.setCoordinates(user);
            if (addCoords) {
                System.out.println("Есть координаты");
            } else {
                System.out.println("Координат нет");
            }
            clientFacade.updateClient(user);
            return "auth";
        }
        return "register";
    }

    @RequestMapping(value = "/auth", method = RequestMethod.POST)
    public String authCheck(@ModelAttribute("user") User user, Model m) {

        user = clientFacade.authoriseUser(user);

        if (user == null || user.getBlocked() == 1) {
            return "redirect:/auth";
        }

        m.addAttribute("user", user);

        if (user.getRole().equals("client")) {
            return "redirect:/view";
        }

        if (user.getRole().equals("manager")) {
            return "redirect:/management";
        }

        return "redirect:/auth";

    }

    @RequestMapping(value = "/buy", method = RequestMethod.POST)
    public String buy(@ModelAttribute("wrapper") Wrapper wrapper,
                      @ModelAttribute("user") User user,
                      Model m) {
        if (clientFacade.countOfBuyProducts(wrapper) == 0) {
            return "redirect:/view";
        }
        clientFacade.filterActivePizzas(wrapper);
        m.addAttribute("orderClient", clientFacade.makeNewOrder(user));
        return "buy";
    }

    @RequestMapping(value = "/order", method = RequestMethod.POST)
    public String order(@ModelAttribute("wrapper") Wrapper wrapper,
                        @ModelAttribute("orderClient") OrderClient orderClient,
                        Model m) {
        clientFacade.fillAndSaveOrder(orderClient,wrapper);
        return "redirect:/view";
    }

    @RequestMapping(value = "/myorders", method = RequestMethod.GET)
    public String orders(@ModelAttribute("user") User user, Model m) {
        //System.out.println(pizzaFacade.getAllOrdersByClient(user));
        m.addAttribute("ordersofclient", clientFacade.getAllOrdersByClient(user));
        m.addAttribute("stats", clientFacade.getStats(user));
        return "orders";
    }

    @RequestMapping(value = "/cancel/{id}", method = RequestMethod.GET)
    public String cancelOrder(@PathVariable("id") Integer id) {
        clientFacade.removeOrder(id);
        return "redirect:/myorders";
    }



}
