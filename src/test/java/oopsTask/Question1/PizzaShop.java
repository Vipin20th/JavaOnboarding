package oopsTask.Question1;

public class PizzaShop {

    public static void main(String[] args) {
        // Create a standard base pizza
        Pizza standardPizza = new StandardPizza();
        standardPizza.addTopping("Tomato");
        standardPizza.addTopping("Mushrooms");

        // Calculate and display the cost
        System.out.println("Cost of standard pizza: $" + standardPizza.calculateCost());

        // Create a soft base pizza
        Pizza softPizza = new SoftPizza();
        softPizza.addTopping("Tomato");
        softPizza.addTopping("Corn");
        softPizza.addTopping("Mushrooms");

        // Calculate and display the cost
        System.out.println("Cost of soft pizza: $" + softPizza.calculateCost());
    }

}
