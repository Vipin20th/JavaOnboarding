package oopsTask.Question2;

public class BouquetShop {

    public static void main(String[] args) {
        // Create a bouquet
        Bouquet bouquet = new Bouquet();
        bouquet.addFlower(FlowerType.ROSE, 5);
        bouquet.addFlower(FlowerType.JASMINE, 3);
        bouquet.addFlower(FlowerType.LILY, 2);

        // Calculate and display the cost
        System.out.println("Cost of the bouquet: $" + bouquet.calculateCost());
    }
}
