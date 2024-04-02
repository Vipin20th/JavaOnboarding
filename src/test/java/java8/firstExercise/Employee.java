package java8.firstExercise;

public class Employee implements Comparable<Employee> {
    private String name;
    private int id;

    public Employee(String name, int id) {
        this.name = name;
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public int getId() {
        return id;
    }

    @Override
    public int compareTo(Employee other) {
        return this.name.compareTo(other.name);
    }
}
