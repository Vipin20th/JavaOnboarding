package oopsTask.Question3;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class GiftManager {
    private List<Sweets> gift;

    public GiftManager() {
        gift = new ArrayList<>();
    }

    public void addSweets(Sweets sweets) {
        gift.add(sweets);
    }

    public double calculateTotalWeight() {
        double totalWeight = 0;
        for (Sweets s : gift) {
            totalWeight += s.getWeight();
        }
        return totalWeight;
    }

    public void sortChocolates(String sortBy) {
        // Implement sorting mechanism based on sortBy option
        // For simplicity, let's assume sorting by type or weight
        if (sortBy.equals("type")) {
            Collections.sort(gift, Comparator.comparing(o -> ((Chocolate) o).getType()));
        } else if (sortBy.equals("weight")) {
            Collections.sort(gift, Comparator.comparing(Sweets::getWeight));
        }
    }

    public List<Candy> findCandiesInRange(double minWeight, double maxWeight) {
        List<Candy> candiesInRange = new ArrayList<>();
        for (Sweets s : gift) {
            if (s instanceof Candy) {
                double weight = s.getWeight();
                if (weight >= minWeight && weight <= maxWeight) {
                    candiesInRange.add((Candy) s);
                }
            }
        }
        return candiesInRange;
    }

    public static void main(String[] args) {
        GiftManager giftManager = new GiftManager();

        // Adding sweets to the gift
        giftManager.addSweets(new Chocolate("Milk Chocolate", 50, "Milk"));
        giftManager.addSweets(new Chocolate("Dark Chocolate", 60, "Dark"));
        giftManager.addSweets(new Chocolate("White Chocolate", 45, "White"));
        giftManager.addSweets(new Candy("Toffee", 30, "Butterscotch"));
        giftManager.addSweets(new Candy("Lollipop", 20, "Fruit"));

        // Calculate total weight of the gift
        System.out.println("Total weight of the gift: " + giftManager.calculateTotalWeight() + " grams");

        // Sort chocolates by type
        giftManager.sortChocolates("type");
        System.out.println("Sorted chocolates by type: ");
        for (Sweets s : giftManager.gift) {
            if (s instanceof Chocolate) {
                System.out.println(((Chocolate) s).getType() + " Chocolate");
            }
        }

        // Find candies within a specified range of options
        List<Candy> candiesInRange = giftManager.findCandiesInRange(25, 35);
        System.out.println("Candies within the specified range: ");
        for (Candy candy : candiesInRange) {
            System.out.println(candy.getFlavor() + " Candy");
        }
    }

}
