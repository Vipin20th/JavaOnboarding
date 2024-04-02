package java8.eigthExercise;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

public class ProductOperations {

    public static void main(String[] args) {
        // Creating a list of products
        List<Product> productList = new ArrayList<>();
        productList.add(new Product("Laptop", 1500.0, "Electronics", "A"));
        productList.add(new Product("Mobile", 800.0, "Electronics", "B"));
        productList.add(new Product("Headphones", 1200.0, "Electronics", "C"));
        productList.add(new Product("Shirt", 2000.0, "Clothing", "A"));

        // 1. Get all the products with price > 1000/-
        Predicate<Product> priceGreaterThan1000 = product -> product.getPrice() > 1000.0;
        List<Product> highPricedProducts = filterProducts(productList, priceGreaterThan1000);
        System.out.println("Products with price > 1000/-:");
        System.out.println(highPricedProducts);

        // 2. Get all the products from electronics category
        Predicate<Product> electronicsCategory = product -> product.getCategory().equals("Electronics");
        List<Product> electronicsProducts = filterProducts(productList, electronicsCategory);
        System.out.println("\nProducts from electronics category:");
        System.out.println(electronicsProducts);

        // 3. Get all the products with price > 1000/- and from electronics category. Change the name of the result list into CAP letters before printing.
        Predicate<Product> highPricedElectronics = priceGreaterThan1000.and(electronicsCategory);
        List<Product> highPricedElectronicsProducts = filterProducts(productList, highPricedElectronics);
        List<Product> upperCaseProducts = changeProductNameToUpperCase(highPricedElectronicsProducts);
        System.out.println("\nHigh priced electronics products with name in CAPS:");
        System.out.println(upperCaseProducts);

        // 4. Calculate the count of all electronic products
        long electronicProductsCount = countProducts(productList, electronicsCategory);
        System.out.println("\nCount of electronic products: " + electronicProductsCount);
    }

    // Method to filter products based on the given predicate
    public static List<Product> filterProducts(List<Product> productList, Predicate<Product> predicate) {
        List<Product> filteredProducts = new ArrayList<>();
        for (Product product : productList) {
            if (predicate.test(product)) {
                filteredProducts.add(product);
            }
        }
        return filteredProducts;
    }

    // Method to change product names to uppercase
    public static List<Product> changeProductNameToUpperCase(List<Product> productList) {
        List<Product> modifiedProducts = new ArrayList<>();
        for (Product product : productList) {
            modifiedProducts.add(new Product(product.getName().toUpperCase(), product.getPrice(), product.getCategory(), product.getGrade()));
        }
        return modifiedProducts;
    }

    // Method to count products based on the given predicate
    public static long countProducts(List<Product> productList, Predicate<Product> predicate) {
        long count = 0;
        for (Product product : productList) {
            if (predicate.test(product)) {
                count++;
            }
        }
        return count;
    }
}
