package java8.seventhExercise;

import java.util.function.Supplier;

public class ConstructorReferenceExample {

    public static void main(String[] args) {
        // Using constructor reference to create Employee objects
        Supplier<Employee> employeeSupplier = () -> new Employee("John Doe", "AC123", 50000.0);

        // Create an Employee object using constructor reference
        Employee employee = employeeSupplier.get();

        // Print details of the Employee object
        System.out.println("Name: " + employee.getName());
        System.out.println("Account: " + employee.getAccount());
        System.out.println("Salary: " + employee.getSalary());
    }
}

