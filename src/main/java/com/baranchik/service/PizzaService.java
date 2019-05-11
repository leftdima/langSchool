package com.baranchik.service;

import com.baranchik.controller.PizzaTransform;
import com.baranchik.model.Pizza;
import com.baranchik.model.Pizzeria;

import java.util.List;

public interface PizzaService {
    List<Pizza> getPizzaList();
    List<PizzaTransform> getTransformsPizzas();
    Pizzeria getDefaultPizzeria();
}