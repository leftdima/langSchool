package com.baranchik.composits;

import com.baranchik.controller.PizzaTransform;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class Wrapper {

    private List<PizzaTransform> pizzaTransformList;

    public Wrapper(){

    }

    public Wrapper(List<PizzaTransform> pizzaTransformList) {
        this.pizzaTransformList = pizzaTransformList;
    }

    public List<PizzaTransform> getPizzaTransformList() {
        return pizzaTransformList;
    }

    public void setPizzaTransformList(List<PizzaTransform> pizzaTransformList) {
        this.pizzaTransformList = pizzaTransformList;
    }
}
