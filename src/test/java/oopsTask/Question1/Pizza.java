package oopsTask.Question1;

import java.util.ArrayList;
import java.util.List;

abstract class Pizza {

    protected String base;
    protected List<String> toppings;

    public Pizza(String base) {
        this.base = base;
        this.toppings = new ArrayList<>();
    }

    public void addTopping(String topping) {
        toppings.add(topping);
    }

    public abstract double calculateCost();
}

