package java8.firstExercise;

import java.util.Collections;
import java.util.Map;
import java.util.TreeMap;

public class TreeMapSortDescendingByName {
    public static void main(String[] args) {
        TreeMap<String, Employee> treeMap = new TreeMap<>(Collections.reverseOrder());

        // Adding employees to TreeMap
        treeMap.put("John", new Employee("John", 101));
        treeMap.put("Alice", new Employee("Alice", 102));
        treeMap.put("Bob", new Employee("Bob", 103));
        treeMap.put("David", new Employee("David", 104));

        // Displaying employees sorted by name in descending order
        System.out.println("Employees sorted by name in descending order:");
        for (Map.Entry<String, Employee> entry : treeMap.entrySet()) {
            System.out.println("Name: " + entry.getKey() + ", ID: " + entry.getValue().getId());
        }
    }
}
