package java8.firstExercise;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class EmployeeSortByName {
    public static void main(String[] args) {
        List<Employee> employees = new ArrayList<>();
        employees.add(new Employee("John", 101));
        employees.add(new Employee("Alice", 102));
        employees.add(new Employee("Bob", 103));
        employees.add(new Employee("David", 104));

        // Sorting employees by name in alphabetical order using Comparator
        Collections.sort(employees, new Comparator<Employee>() {
            @Override
            public int compare(Employee e1, Employee e2) {
                return e1.getName().compareTo(e2.getName());
            }
        });

        // Printing the sorted list of employees
        System.out.println("Employees sorted by name:");
        for (Employee employee : employees) {
            System.out.println("Name: " + employee.getName() + ", ID: " + employee.getId());
        }
    }
}
