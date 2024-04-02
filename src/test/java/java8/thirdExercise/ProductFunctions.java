package java8.thirdExercise;

import java.util.List;
import java.util.function.Predicate;

public class ProductFunctions {

    // Function to calculate the cost of all products in a given list
    public static double calculateTotalCost(List<Product> products) {
        return products.stream()
                .mapToDouble(Product::getPrice)
                .sum();
    }

    // Function to calculate the cost of all products whose price is > 1000/- in the given list
    public static double calculateCostOfExpensiveProducts(List<Product> products) {
        return products.stream()
                .filter(p -> p.getPrice() > 1000)
                .mapToDouble(Product::getPrice)
                .sum();
    }

    // Function to calculate the cost of all electronic products in the given list
    public static double calculateCostOfElectronicProducts(List<Product> products) {
        return products.stream()
                .filter(p -> p.getCategory().equals("Electronics"))
                .mapToDouble(Product::getPrice)
                .sum();
    }

    // Function to get all the products whose price is > 1000/- and belongs to electronic category
    public static List<Product> getExpensiveElectronicProducts(List<Product> products) {
        Predicate<Product> expensiveElectronicFilter = p -> p.getPrice() > 1000 && p.getCategory().equals("Electronics");
        return products.stream()
                .filter(expensiveElectronicFilter)
                .toList();
    }

    public static void main(String[] args) {
        // Creating list of products
        List<Product> products = List.of(
                new Product("Laptop", 1500, "Electronics", "A"),
                new Product("Mobile", 800, "Electronics", "B"),
                new Product("Headphones", 1200, "Electronics", "C"),
                new Product("Shirt", 2000, "Clothing", "A")
        );

        // Calculate the cost of all products
        System.out.println("Total cost of all products: " + calculateTotalCost(products));

        // Calculate the cost of all products whose price is > 1000/-
        System.out.println("Total cost of expensive products: " + calculateCostOfExpensiveProducts(products));

        // Calculate the cost of all electronic products
        System.out.println("Total cost of electronic products: " + calculateCostOfElectronicProducts(products));

        // Get all the products whose price is > 1000/- and belongs to electronic category
        List<Product> expensiveElectronicProducts = getExpensiveElectronicProducts(products);
        System.out.println("Expensive electronic products:");
        expensiveElectronicProducts.forEach(p -> System.out.println(p.getName()));
    }
}
