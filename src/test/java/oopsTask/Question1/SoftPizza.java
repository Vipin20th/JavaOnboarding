package oopsTask.Question1;

public class SoftPizza extends Pizza{

    private double baseCost = 6.0;
    private double toppingCost = 1.5; // Cost per topping

    public SoftPizza() {
        super("Soft");
    }

    @Override
    public double calculateCost() {
        return baseCost + (toppings.size() * toppingCost);
    }
}
