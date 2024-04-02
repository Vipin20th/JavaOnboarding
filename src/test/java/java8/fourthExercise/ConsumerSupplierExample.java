package java8.fourthExercise;

import java.util.function.Consumer;
import java.util.function.Supplier;

public class ConsumerSupplierExample {

    // Consumer to print product to appropriate medium
    static Consumer<Product> printProduct = product -> {
        System.out.println("Printing product:");
        System.out.println("Name: " + product.getName());
        System.out.println("Price: " + product.getPrice());
        System.out.println("Category: " + product.getCategory());
        System.out.println("Grade: " + product.getGrade());
        System.out.println("-------------------------------------");
    };

    // Consumer to update grade to 'Premium' for products with price > 1000
    static Consumer<Product> updateGradeToPremium = product -> {
        if (product.getPrice() > 1000) {
            product.setGrade("Premium");
        }
    };

    // Consumer to update name to be suffixed with '*' for products with price > 3000
    static Consumer<Product> updateNameWithSuffix = product -> {
        if (product.getPrice() > 3000) {
            product.setName(product.getName() + "*");
        }
    };

    // Supplier to produce a random product
    static Supplier<Product> randomProductSupplier = () -> {
        // For demonstration purposes, generating random values
        String[] names = {"Laptop", "Mobile", "Headphones", "Shirt", "Watch"};
        String[] categories = {"Electronics", "Clothing", "Accessories"};
        double price = Math.random() * 5000; // Random price between 0 and 5000
        String name = names[(int) (Math.random() * names.length)];
        String category = categories[(int) (Math.random() * categories.length)];
        String grade = "Standard";
        return new Product(name, price, category, grade);
    };

    public static void main(String[] args) {
        // Example of using Consumer to print product
        Product product1 = new Product("Laptop", 1200, "Electronics", "Standard");
        printProduct.accept(product1);

        // Example of using Consumer to update grade to 'Premium'
        Product product2 = new Product("Mobile", 900, "Electronics", "Standard");
        updateGradeToPremium.accept(product2);
        printProduct.accept(product2);

        // Example of using Consumer to update name with '*' suffix
        Product product3 = new Product("Headphones", 3500, "Electronics", "Standard");
        updateNameWithSuffix.accept(product3);
        printProduct.accept(product3);

        // Example of using Supplier to produce a random product
        Product randomProduct = randomProductSupplier.get();
        printProduct.accept(randomProduct);
    }
}
