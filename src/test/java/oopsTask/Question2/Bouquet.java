package oopsTask.Question2;

import java.util.HashMap;
import java.util.Map;

public class Bouquet {

    private Map<FlowerType, Integer> flowers;

    public Bouquet() {
        flowers = new HashMap<>();
    }

    // Add flowers to the bouquet
    public void addFlower(FlowerType type, int quantity) {
        flowers.put(type, quantity);
    }

    // Calculate the total cost of the bouquet
    public double calculateCost() {
        double totalCost = 0.0;
        for (Map.Entry<FlowerType, Integer> entry : flowers.entrySet()) {
            FlowerType type = entry.getKey();
            int quantity = entry.getValue();
            Flower flower = new Flower(type);
            totalCost += flower.getCost() * quantity;
        }
        return totalCost;
    }
}
