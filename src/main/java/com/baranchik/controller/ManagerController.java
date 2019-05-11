package com.baranchik.controller;

import com.baranchik.facade.ManagerFacade;
import com.baranchik.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@SessionAttributes({"orders"})
public class ManagerController {

    @Autowired
    private ManagerFacade managerFacade;

    @RequestMapping(value = "/management", method = RequestMethod.GET)
    public String management(Model model) {
        model.addAttribute("orders", managerFacade.getOrders());
        return "manage";
    }

    @RequestMapping(value = "/process/{id}", method = RequestMethod.GET)
    public String processed(@PathVariable("id") Integer id) {
        //clientFacade.removeOrder(id);
        return "redirect:/myorders";
    }

    @RequestMapping(value = "/delivery/{id}", method = RequestMethod.GET)
    public String delivery(@PathVariable("id") Integer id) {
        //clientFacade.removeOrder(id);
        return "redirect:/myorders";
    }

}
