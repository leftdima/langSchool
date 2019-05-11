package com.baranchik.repository;


import com.baranchik.model.Check;
import com.baranchik.model.OrderClient;
import com.baranchik.model.User;
import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.List;

@Repository
public class OrderRepositoryImpl implements OrderRepository {

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public void save(OrderClient orderClient) {
        sessionFactory.getCurrentSession().saveOrUpdate(orderClient);
    }

    @Override
    public void remove(OrderClient orderClient) {
        sessionFactory
                .getCurrentSession()
                .createSQLQuery("delete from `order` where `id` = :orderid")
                .setParameter("orderid", orderClient.getId())
                .executeUpdate();
    }


    @Override
    public void save(Check check) {
        sessionFactory
                .getCurrentSession()
                .createSQLQuery("insert into `check`(`order`, `pizza`, `amount`) values (:ord, :pizza, :am)")
                .setParameter("am", check.getAmount())
                .setParameter("ord", check.getOrderClient().getId())
                .setParameter("pizza", check.getPizza1().getId())
                .executeUpdate();
        //sessionFactory.getCurrentSession().save(check);
    }

    @SuppressWarnings("unchecked")
    @Override
    public List<OrderClient> getAllOrders() {
        return sessionFactory
                .getCurrentSession()
                .createQuery("from OrderClient order by orderDate desc")
                .list();
    }

    @SuppressWarnings("unchecked")
    @Override
    public List<OrderClient> getOrdersByClient(User user) {
        return sessionFactory
                .getCurrentSession()
                .createQuery("from OrderClient where user = :client order by orderDate desc")
                .setInteger("client", user.getId())
                .list();
    }

    @Override
    public BigDecimal getSummOfPaying(User user) {
        return (BigDecimal)sessionFactory
                .getCurrentSession()
                .createSQLQuery("select sum(`order`.orderPrice) from `order` where `user` = :client")
                .setInteger("client", user.getId())
                .uniqueResult();
    }

    @Override
    public BigDecimal getAverageSum(User user) {
        return (BigDecimal)sessionFactory
                .getCurrentSession()
                .createSQLQuery("select avg(`order`.`orderPrice`) from `order` where `user` = :client")
                .setInteger("client", user.getId())
                .uniqueResult();
    }

    @Override
    public BigInteger getCountOfOrders(User user) {
        return (BigInteger)sessionFactory
                .getCurrentSession()
                .createSQLQuery("select count(*) from `order` where `user` = :client")
                .setInteger("client", user.getId())
                .uniqueResult();
    }

    @Override
    public OrderClient getOrder(Integer id) {
        return (OrderClient) sessionFactory
                .getCurrentSession()
                .get(OrderClient.class, id);
    }
}
