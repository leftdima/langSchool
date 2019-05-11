package com.baranchik.repository;

import com.baranchik.model.Pizza;
import com.baranchik.model.Pizzeria;

import java.util.List;

public interface PizzaRepository {
    List<Pizza> getPizzaList();
    Pizzeria getDefaultPizzeria();
}
