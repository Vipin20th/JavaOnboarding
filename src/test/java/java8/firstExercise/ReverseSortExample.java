package java8.firstExercise;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class ReverseSortExample {
    public static void main(String[] args) {
        List<Integer> numbers = Arrays.asList(5, 2, 8, 1, 9, 3);

        // Sorting the list in reverse order using Comparator
        Collections.sort(numbers, new Comparator<Integer>() {
            @Override
            public int compare(Integer num1, Integer num2) {
                return num2.compareTo(num1); // Compare in reverse order
            }
        });

        // Printing the sorted list
        System.out.println("Numbers sorted in reverse order:");
        for (Integer number : numbers) {
            System.out.print(number + " ");
        }
    }
}
