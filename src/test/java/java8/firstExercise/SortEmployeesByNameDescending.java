package java8.firstExercise;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class SortEmployeesByNameDescending {

    public static void main(String[] args) {
        List<Employee> employees = new ArrayList<>();
        employees.add(new Employee("John", 101));
        employees.add(new Employee("Alice", 102));
        employees.add(new Employee("Bob", 103));
        employees.add(new Employee("David", 104));

        // Sort employees by name in descending order
        Collections.sort(employees, new Comparator<Employee>() {
            @Override
            public int compare(Employee e1, Employee e2) {
                return e2.getName().compareTo(e1.getName());
            }
        });

        // Print sorted employees
        System.out.println("Sorted Employees (Descending order of name):");
        for (Employee employee : employees) {
            System.out.println("Name: " + employee.getName() + ", ID: " + employee.getId());
        }
    }
}
