package java8.sixthExercise;


import java.util.Random;
import java.util.function.IntConsumer;
import java.util.function.IntPredicate;
import java.util.function.IntSupplier;

public class ProductFunctions {

    static class Product {
        private String name;
        private double price;
        private String category;
        private String grade;

        public Product(String name, double price, String category, String grade) {
            this.name = name;
            this.price = price;
            this.category = category;
            this.grade = grade;
        }

        public String getName() {
            return name;
        }

        public double getPrice() {
            return price;
        }

        public String getCategory() {
            return category;
        }

        public String getGrade() {
            return grade;
        }
    }

    // Write an IntPredicate to verify if the given number is a prime number
    static IntPredicate isPrime = n -> {
        if (n <= 1) {
            return false;
        }
        for (int i = 2; i <= Math.sqrt(n); i++) {
            if (n % i == 0) {
                return false;
            }
        }
        return true;
    };

    // Write an IntConsumer to print square of the given number
    static IntConsumer printSquare = n -> System.out.println("Square of " + n + ": " + (n * n));

    // Write an IntSupplier to give random int below 5000
    static IntSupplier randomIntBelow5000 = () -> new Random().nextInt(5000);

    public static void main(String[] args) {
        // Test isPrime IntPredicate
        int number1 = 17;
        System.out.println(number1 + " is prime: " + isPrime.test(number1));

        // Test printSquare IntConsumer
        int number2 = 5;
        printSquare.accept(number2);

        // Test randomIntBelow5000 IntSupplier
        int randomNumber = randomIntBelow5000.getAsInt();
        System.out.println("Random number below 5000: " + randomNumber);
    }
}
