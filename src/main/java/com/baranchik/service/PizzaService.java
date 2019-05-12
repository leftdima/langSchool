package com.baranchik.service;

import com.baranchik.composits.PizzaTransform;
import com.baranchik.model.Pizza;
import com.baranchik.model.Pizzeria;

import java.util.List;

public interface PizzaService {
    List<Pizza> getPizzaList();
    List<PizzaTransform> getTransformsPizzas();
    Pizzeria getDefaultPizzeria();
    Pizzeria getPizzeria(Integer id);
    List<Pizzeria> getPizzerias();
}
