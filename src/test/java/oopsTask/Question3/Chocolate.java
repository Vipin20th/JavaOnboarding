package oopsTask.Question3;


public class Chocolate extends Sweets {
    private String type;

    public Chocolate(String name, double weight, String type) {
        super(name, weight);
        this.type = type;
    }

    public String getType() {
        return type;
    }
}

