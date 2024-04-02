package oopsTask.Question1;

public class StandardPizza extends Pizza{

    private double baseCost = 5.0;
    private double toppingCost = 1.0; // Cost per topping

    public StandardPizza() {
        super("Standard");
    }

    @Override
    public double calculateCost() {
        return baseCost + (toppings.size() * toppingCost);
    }
}
