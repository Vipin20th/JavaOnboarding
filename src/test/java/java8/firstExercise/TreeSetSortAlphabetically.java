package java8.firstExercise;

import java.util.TreeSet;

public class TreeSetSortAlphabetically {
    public static void main(String[] args) {
        TreeSet<Employee> treeSet = new TreeSet<>();

        // Adding employees to TreeSet
        treeSet.add(new Employee("John", 101));
        treeSet.add(new Employee("Alice", 102));
        treeSet.add(new Employee("Bob", 103));
        treeSet.add(new Employee("David", 104));

        // Displaying employees sorted by name alphabetically
        System.out.println("Employees sorted by name alphabetically:");
        for (Employee employee : treeSet) {
            System.out.println("Name: " + employee.getName() + ", ID: " + employee.getId());
        }
    }

}
