package java8.seventhExercise;


public class Employee {
    private String name;
    private String account;
    private double salary;

    public Employee(String name, String account, double salary) {
        this.name = name;
        this.account = account;
        this.salary = salary;
    }

    public String getName() {
        return name;
    }

    public String getAccount() {
        return account;
    }

    public double getSalary() {
        return salary;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "name='" + name + '\'' +
                ", account='" + account + '\'' +
                ", salary=" + salary +
                '}';
    }
}
