package com.baranchik.facade;

import com.baranchik.mail.MailUtil;
import com.baranchik.model.OrderClient;
import com.baranchik.model.Pizzeria;
import com.baranchik.service.OrderService;
import com.baranchik.service.PizzaService;
import com.baranchik.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ManagerFacade {

    @Autowired
    private UserService userService;
    @Autowired
    private PizzaService pizzaService;
    @Autowired
    private OrderService orderService;
    @Autowired
    private MailUtil mailUtil;

    public List<OrderClient> getOrders(){
        return orderService.getAllOrders();
    }

    public boolean sendMailAndProcessOrder(Integer id){
        OrderClient orderClient = orderService.getOrderClient(id);
        boolean result = mailUtil.sendMessage(orderClient);
        if (result){
            orderClient.setProcessed((short) 1);
            orderService.save(orderClient);
            return true;
        } else {
            return false;
        }
    }

    public void deliveryOrder(Integer id){
        OrderClient orderClient = orderService.getOrderClient(id);
        orderClient.setDelivered((short) 1);
        orderClient.setDeliveryDate(orderService.getNowTime());
        orderService.save(orderClient);
    }

    public OrderClient getOrder(Integer id){
        return orderService.getOrderClient(id);
    }

    public List<Pizzeria> getListPizzeria(){
        return pizzaService.getPizzerias();
    }

    public Pizzeria getPizzeria(Integer id){
        return pizzaService.getPizzeria(id);
    }



}
