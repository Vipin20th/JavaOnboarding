package designPatterns.fifthTask;

public class Main {
    public static void main(String[] args) {
        // Build a Bicycle with gears and a double stand
        Bicycle bike1 = new Bicycle.Builder()
                .addGears()
                .addDoubleStand()
                .build();

        // Build a Bicycle with double seats and a carrier
        Bicycle bike2 = new Bicycle.Builder()
                .addDoubleSeats()
                .addCarrier()
                .build();

        // Build a Bicycle with all options
        Bicycle bike3 = new Bicycle.Builder()
                .addGears()
                .addDoubleStand()
                .addDoubleSeats()
                .addCarrier()
                .build();
    }
}
