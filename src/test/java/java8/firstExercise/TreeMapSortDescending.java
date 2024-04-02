package java8.firstExercise;

import java.util.Collections;
import java.util.Map;
import java.util.TreeMap;

public class TreeMapSortDescending {

    public static void main(String[] args) {
        TreeMap<Integer, String> treeMap = new TreeMap<>(Collections.reverseOrder());

        // Adding values to TreeMap
        treeMap.put(3, "Three");
        treeMap.put(1, "One");
        treeMap.put(4, "Four");
        treeMap.put(2, "Two");

        // Displaying TreeMap sorted by keys in descending order
        System.out.println("Values sorted in descending order:");
        for (Map.Entry<Integer, String> entry : treeMap.entrySet()) {
            System.out.println("Key: " + entry.getKey() + ", Value: " + entry.getValue());
        }
    }
}
