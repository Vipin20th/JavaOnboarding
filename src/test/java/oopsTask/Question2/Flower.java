package oopsTask.Question2;

public class Flower {

    private FlowerType type;

    public Flower(FlowerType type) {
        this.type = type;
    }

    public double getCost() {
        switch (type) {
            case ROSE:
                return 1.0;
            case JASMINE:
                return 2.0;
            case LILY:
                return 3.0;
            default:
                return 0.0;
        }
    }
}
