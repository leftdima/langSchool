package com.baranchik.facade;

import com.baranchik.composits.ClientStats;
import com.baranchik.controller.PizzaTransform;
import com.baranchik.composits.Wrapper;
import com.baranchik.model.Address;
import com.baranchik.model.OrderClient;
import com.baranchik.model.User;
import com.baranchik.service.OrderService;
import com.baranchik.service.PizzaService;
import com.baranchik.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.util.List;

@Component
public class ClientFacade {

    @Autowired
    private UserService userService;
    @Autowired
    private PizzaService pizzaService;
    @Autowired
    private OrderService orderService;

    public Wrapper getWrapper(){
        Wrapper wrapper = new Wrapper();
        wrapper.setPizzaTransformList(pizzaService.getTransformsPizzas());
        return wrapper;
    }

    public void updateClient(User user) {
        userService.saveAddress(user.getAddress());
        userService.saveUser(user);
    }

    public User getUserForRegister(){
        User newUser = new User();
        newUser.setAddress(new Address());
        return newUser;
    }

    public User getUserByLogin(String login) {
        return userService.getByLogin(login);
    }

    public User authoriseUser(User user) {
        return userService.authoriseUser(user.getLogin(), user.getPassword());
    }

    public void filterActivePizzas(Wrapper wrapper){
        orderService.filterOrder(wrapper);
    }

    public OrderClient makeNewOrder(User user) {
        OrderClient orderClient = new OrderClient();
        orderClient.setUser(user);
        return orderClient;
    }

    public void fillAndSaveOrder(OrderClient orderClient, Wrapper wrapper){
        orderClient.setOrderDate(orderService.getNowTime());
        //NOW DEFAULT orderClient.setPizzeria();
        orderClient.setId(orderService.generateId(orderClient));
        orderClient.setOrderPrice(new BigDecimal(0));
        orderClient.setPizzeria(pizzaService.getDefaultPizzeria());
        orderService.save(orderClient);
        //System.out.println(orderClient);
        orderService.addChecks(wrapper, orderClient);
        orderClient = orderService.getOrderClient(orderClient.getId());
        orderClient.setOrderPrice(orderService.calcTotalCost(orderClient));
        orderService.save(orderClient);
    }

    public long countOfBuyProducts(Wrapper wrapper) {
        return wrapper.getPizzaTransformList().stream().filter(PizzaTransform::isOrdered).count();
    }

    public List<OrderClient> getAllOrders() {
        return orderService.getAllOrders();
    }

    public List<OrderClient> getAllOrdersByClient(User user) {
        List<OrderClient> orderClients = orderService.getOrdersByClient(user);
        return orderClients;
    }

    public void removeOrder(Integer id){
        orderService.remove(orderService.getOrderClient(id));
    }

    public ClientStats getStats(User user) {
        return new ClientStats(
                orderService.getAverageSum(user),
                orderService.getSummOfPaying(user),
                orderService.getCountOfOrders(user)
        );
    }

}
