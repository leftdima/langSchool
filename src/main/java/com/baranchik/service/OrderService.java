package com.baranchik.service;


import com.baranchik.composits.Wrapper;
import com.baranchik.model.OrderClient;
import com.baranchik.model.User;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Date;
import java.util.List;

public interface OrderService {
    void save(OrderClient orderClient);
    void remove(OrderClient orderClient);
    List<OrderClient> getAllOrders();
    List<OrderClient> getOrdersByClient(User user);
    BigDecimal getAverageSum(User user);
    BigDecimal getSummOfPaying(User user);
    BigInteger getCountOfOrders(User user);
    Date getNowTime();
    BigDecimal calcTotalCost(OrderClient orderClient);
    //Set<Check> getChecks(List<PizzaTransform> pizzaListWrapper, OrderClient orderClient);
    void filterOrder(Wrapper wrapper);
    void addChecks(Wrapper wrapper, OrderClient order);
    Integer generateId(OrderClient orderClient);
    OrderClient getOrderClient(Integer id);
}
