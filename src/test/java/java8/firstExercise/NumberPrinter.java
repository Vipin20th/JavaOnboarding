package java8.firstExercise;

public class NumberPrinter implements Runnable {
    private int limit;

    public NumberPrinter(int limit) {
        this.limit = limit;
    }

    @Override
    public void run() {
        for (int i = 1; i <= limit; i++) {
            System.out.println(Thread.currentThread().getName() + ": " + i);
            try {
                // Adding a short delay for demonstration purposes
                Thread.sleep(1000); // Sleep for 1 second
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        // Create a new Thread with a NumberPrinter instance as the Runnable
        Thread thread = new Thread(new NumberPrinter(10));

        // Start the thread
        thread.start();
    }
}