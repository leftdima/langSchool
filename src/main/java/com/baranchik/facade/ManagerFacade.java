package com.baranchik.facade;

import com.baranchik.model.OrderClient;
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

    public List<OrderClient> getOrders(){
        return orderService.getAllOrders();
    }

}
