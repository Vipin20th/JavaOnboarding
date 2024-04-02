package java8.secondExercise;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

public class PredicatesExample {

    public static void main(String[] args) {
        // Creating list of products
        List<Product> products = new ArrayList<>();
        products.add(new Product("Laptop", 1500, "Electronics", "A"));
        products.add(new Product("Mobile", 800, "Electronics", "B"));
        products.add(new Product("Headphones", 120, "Electronics", "C"));
        products.add(new Product("Shirt", 2000, "Clothing", "A"));

        // Creating list of responses
        List<Response> responses = new ArrayList<>();
        responses.add(new Response("{}", 200, "JSON"));
        responses.add(new Response("{}", 400, "XML"));
        responses.add(new Response("{}", 400, "JSON"));
        responses.add(new Response("{}", 500, "JSON"));

        // Predicate to check if price of product is greater than 1000
        Predicate<Product> priceGreaterThan1000 = p -> p.getPrice() > 1000;

        // Predicate to check if product is of electronics category
        Predicate<Product> electronicsCategory = p -> p.getCategory().equals("Electronics");

        // Predicate to check if status code is 400
        Predicate<Response> statusCode400 = r -> r.getStatusCode() == 400;

        // Predicate to check if response type is JSON
        Predicate<Response> responseTypeJSON = r -> r.getResponseType().equals("JSON");

        // Predicates combined using logical AND, OR, and NEGATE
        Predicate<Product> priceGreaterThan100OrElectronics = priceGreaterThan1000.or(electronicsCategory);
        Predicate<Product> priceLessThan100AndElectronics = priceGreaterThan1000.negate().and(electronicsCategory);
        Predicate<Response> statusCode400AndJSON = statusCode400.and(responseTypeJSON);
        Predicate<Response> statusCode400OrJSON = statusCode400.or(responseTypeJSON);
        Predicate<Response> statusCodeNot400AndJSON = statusCode400.negate().and(responseTypeJSON);

        // Printing products based on predicates
        System.out.println("Products with price greater than 1000:");
        products.stream().filter(priceGreaterThan1000).forEach(p -> System.out.println(p.getName()));

        System.out.println("\nProducts of electronics category:");
        products.stream().filter(electronicsCategory).forEach(p -> System.out.println(p.getName()));

        System.out.println("\nProducts with price greater than 100 and in electronics category:");
        products.stream().filter(priceGreaterThan100OrElectronics).forEach(p -> System.out.println(p.getName()));

        System.out.println("\nProducts with price greater than 100 or in electronics category:");
        products.stream().filter(priceLessThan100AndElectronics).forEach(p -> System.out.println(p.getName()));

        // Printing responses based on predicates
        System.out.println("\nResponses with status code 400:");
        responses.stream().filter(statusCode400).forEach(r -> System.out.println(r.getStatusCode()));

        System.out.println("\nResponses with response type JSON:");
        responses.stream().filter(responseTypeJSON).forEach(r -> System.out.println(r.getResponseType()));

        System.out.println("\nResponses with status code 400 and response type JSON:");
        responses.stream().filter(statusCode400AndJSON).forEach(r -> System.out.println(r.getStatusCode() + ", " + r.getResponseType()));

        System.out.println("\nResponses with status code 400 or response type JSON:");
        responses.stream().filter(statusCode400OrJSON).forEach(r -> System.out.println(r.getStatusCode() + ", " + r.getResponseType()));

        System.out.println("\nResponses with status code not 400 and response type JSON:");
        responses.stream().filter(statusCodeNot400AndJSON).forEach(r -> System.out.println(r.getStatusCode() + ", " + r.getResponseType()));
    }
}
