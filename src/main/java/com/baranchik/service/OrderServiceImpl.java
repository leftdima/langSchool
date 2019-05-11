package com.baranchik.service;

import com.baranchik.composits.PizzaTransform;
import com.baranchik.composits.Wrapper;
import com.baranchik.model.Check;
import com.baranchik.model.CheckPK;
import com.baranchik.model.OrderClient;
import com.baranchik.model.User;
import com.baranchik.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.time.LocalDateTime;
import java.util.*;
import java.util.stream.Collectors;

@Service
public class OrderServiceImpl implements OrderService {

    @Autowired
    private OrderRepository orderRepository;

    @Override
    @Transactional
    public void save(OrderClient orderClient) {
        orderRepository.save(orderClient);
    }

    @Override
    @Transactional
    public void remove(OrderClient orderClient) {
        orderRepository.remove(orderClient);
    }

    @Override
    @Transactional
    public List<OrderClient> getAllOrders() {
        return orderRepository.getAllOrders();
    }

    @Override
    @Transactional
    public List<OrderClient> getOrdersByClient(User user) {
        return orderRepository.getOrdersByClient(user);
    }

    @Override
    @Transactional
    public BigDecimal getAverageSum(User user) {
        return orderRepository.getAverageSum(user);
    }

    @Override
    @Transactional
    public BigDecimal getSummOfPaying(User user) {
        return orderRepository.getSummOfPaying(user);
    }

    @Override
    @Transactional
    public BigInteger getCountOfOrders(User user) {
        return orderRepository.getCountOfOrders(user);
    }

    @Override
    @Transactional
    public OrderClient getOrderClient(Integer id) {
        return orderRepository.getOrder(id);
    }

    @Override
    public BigDecimal calcTotalCost(OrderClient orderClient) {
        return orderClient
                .getCheckSet()
                .stream()
                .map(check -> BigDecimal.valueOf(check.getAmount())
                        .multiply(check.getPizza1().getCost())
                        .multiply(check.getPizza1().getSize1().getCoefficient()))
                .reduce(BigDecimal::add)
                .get();
    }

    @Override
    public Date getNowTime() {
        return java.sql.Timestamp.valueOf(LocalDateTime.now());
    }

    @Override
    @Transactional
    public void addChecks(Wrapper wrapper, OrderClient order) {

        wrapper
                .getPizzaTransformList()
                .forEach(pizzaTransform -> {
                    Check tempCheck = new Check();
                    tempCheck.setCheckPK(new CheckPK(order.getId(),
                            pizzaTransform.getPizza().getId()));
                    tempCheck.setOrderClient(order);
                    tempCheck.setAmount(pizzaTransform.getCount());
                    tempCheck.setPizza1(pizzaTransform.getPizza());
                    orderRepository.save(tempCheck);
                });
    }

    @Override
    public void filterOrder(Wrapper wrapper) {
        wrapper.setPizzaTransformList(wrapper
                .getPizzaTransformList()
                .stream()
                .filter(PizzaTransform::isOrdered)
                .collect(Collectors.toList()));
    }

    @Override
    public Integer generateId(OrderClient orderClient) {
        Date date = orderClient.getOrderDate();
        Integer generateId = Math.abs(
                Objects.hash(
                        orderClient.getUser().getId(),
                        date.getYear(),
                        date.getMonth(),
                        date.getDay(), date.getHours(),
                        date.getMinutes(),
                        date.getSeconds()));
        System.out.println("generateID:" + generateId);
        return Integer.valueOf(generateId);
    }
}
