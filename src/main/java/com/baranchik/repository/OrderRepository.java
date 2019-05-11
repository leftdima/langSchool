package com.baranchik.repository;

import com.baranchik.model.Check;
import com.baranchik.model.OrderClient;
import com.baranchik.model.User;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.List;

public interface OrderRepository {
    void save(OrderClient orderClient);
    void remove(OrderClient orderClient);
    void save(Check check);
    List<OrderClient> getAllOrders();
    List<OrderClient> getOrdersByClient(User user);
    BigDecimal getAverageSum(User user);
    BigDecimal getSummOfPaying(User user);
    BigInteger getCountOfOrders(User user);
    OrderClient getOrder(Integer id);
}
