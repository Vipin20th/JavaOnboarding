package java8.firstExercise;

import java.util.*;

public class Programs {

    public static void string_palindrom() {
        String s = "racecar";
        String newS = "";
        for (int i = s.length() - 1; i >= 0; --i) {
            newS += s.charAt(i);
        }
        if (s.equals(newS)) {
            System.out.println("palindrom");
        } else {
            System.out.println("not palindrom");
        }
    }

    public static void find_largest_second_third_Elements() {
        int[] arr = {2, 4, 6, 7, 9};
        int largest = Integer.MIN_VALUE;
        int secondLargest = Integer.MIN_VALUE;
        int thirdLargest = Integer.MIN_VALUE;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] > largest) {
                thirdLargest = secondLargest;
                secondLargest = largest;
                largest = arr[i];

            } else if (arr[i] > secondLargest) {
                thirdLargest = secondLargest;
                secondLargest = arr[i];
            } else if (arr[i] > thirdLargest) {
                thirdLargest = arr[i];
            }
        }
        System.out.println("largetst : " + largest);
        System.out.println("Secondlargetst : " + secondLargest);
        System.out.println("Thirdlargetst : " + thirdLargest);
    }

    public boolean checkRotation(String st1, String st2) {
        if (st1.length() != st2.length()) {
            return false;
        }
        String st3 = st1 + st1;
        if (st3.contains(st2))
            return true;
        else
            return false;
    }

    public static void reverseOrder() {
        List<String> stringList
                = Arrays.asList("Aman", "Kajal",
                "Joyita", "Das");

        System.out.println("Before sorting:");
        System.out.println(stringList.toString());

        stringList.sort(Comparator.reverseOrder());
        System.out.println("\nAfter sorting:");
        System.out.println(stringList.toString());
    }


    public void reverseOrderUsingTreeset(){
        Set<Integer> numbers = new TreeSet<>();
        numbers.add(181);
        numbers.add(219);
        numbers.add(529);
        numbers.add(761);
        numbers.add(431);
        numbers.add(671);
        numbers.add(351);
        System.out.println("1. Original TreeSet<Integer> in ASC order :- \n");
        numbers.forEach(System.out::println);
        System.out.println("\n2. TreeSet<Integer> in DESC order :- \n");
        numbers
                .stream() // get sequential stream
                .sorted(Comparator.reverseOrder()) // reverse order sorting
                .forEach(System.out::println); //
    }

    public static void main(String[] args) {
        Programs.reverseOrder();
    }
}
