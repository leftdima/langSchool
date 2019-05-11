package com.baranchik.repository;

import com.baranchik.model.Pizza;
import com.baranchik.model.Pizzeria;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class PizzaRepositoryImpl implements PizzaRepository {

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public List<Pizza> getPizzaList() {
        return sessionFactory
                .getCurrentSession()
                .createQuery("from Pizza")
                .list();
    }

    @Override
    public Pizzeria getDefaultPizzeria() {
        return (Pizzeria)sessionFactory
                .getCurrentSession()
                .createQuery("from Pizzeria where id = :id")
                .setParameter("id", 1)
                .uniqueResult();
    }
}
