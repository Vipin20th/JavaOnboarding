package java8.fifthExercise;


import java.util.HashMap;
import java.util.Map;
import java.util.function.BiFunction;


public class BiFunctionExample {

    // BiFunction to create a product given name and price
    static BiFunction<String, Double, Product> createProduct = (name, price) -> new Product(name, price, "", "");

    // BiFunction to calculate the cost of products in a cart
    static BiFunction<Map<Product, Integer>, Product, Double> calculateCartCost = (cart, product) -> {
        int quantity = cart.getOrDefault(product, 0);
        return product.getPrice() * quantity;
    };

    public static void main(String[] args) {
        // Creating a product using BiFunction
        Product product1 = createProduct.apply("Laptop", 1500.0);
        System.out.println("Created Product: " + product1);

        // Creating a cart (map of products and quantity)
        Map<Product, Integer> cart = new HashMap<>();
        cart.put(new Product("Laptop", 1500.0, "Electronics", ""), 2);
        cart.put(new Product("Mobile", 800.0, "Electronics", ""), 3);
        cart.put(new Product("Headphones", 120.0, "Electronics", ""), 1);

        // Calculating the cost of the cart using BiFunction
        double totalCost = calculateCartCost.apply(cart, product1);
        System.out.println("Cost of Product in Cart: " + totalCost);
    }
}
