package com.baranchik.composits;

import com.baranchik.model.Pizza;
import org.springframework.stereotype.Component;

@Component
public class PizzaTransform {
    private Pizza pizza;

    public boolean isOrdered() {
        return ordered;
    }

    public void setOrdered(boolean ordered) {
        this.ordered = ordered;
    }

    private boolean ordered;
    private int count;

    public PizzaTransform() {
    }

    public PizzaTransform(Pizza pizza, boolean ordered) {
        this.pizza = pizza;
        this.ordered = ordered;
    }

    public PizzaTransform(Pizza pizza, boolean ordered, int count) {
        this.pizza = pizza;
        this.ordered = ordered;
        this.count = count;
    }

    public Pizza getPizza() {
        return pizza;
    }

    public void setPizza(Pizza pizza) {
        this.pizza = pizza;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    @Override
    public String toString() {
        return "PizzaTransform{" +
                "pizza=" + pizza +
                ", ordered=" + ordered +
                ", count=" + count +
                '}';
    }
}
