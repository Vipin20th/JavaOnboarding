package oopsTask.Question3;

public class Candy extends Sweets {
    private String flavor;

    public Candy(String name, double weight, String flavor) {
        super(name, weight);
        this.flavor = flavor;
    }

    public String getFlavor() {
        return flavor;
    }
}

