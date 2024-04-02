package designPatterns.firstTask;

public class CandyMaker {

    private static volatile CandyMaker instance;

    private boolean empty;
    private boolean boiled;

    private CandyMaker() {
        empty = true;
        boiled = false;
    }

    public static CandyMaker getInstance() {
        if (instance == null) {
            synchronized (CandyMaker.class) {
                if (instance == null) {
                    instance = new CandyMaker();
                }
            }
        }
        return instance;
    }

    public void fill() {
        if (isEmpty()) {
            empty = false;
            boiled = false;
            // fill the candyMaker with milk and chocolate mix
        }
    }

    public void drain() {
        if (!isEmpty() && isBoiled()) {
            // drain the boiled milk and chocolate
            empty = true;
        }
    }

    public void boil() {
        if (!isEmpty() && !isBoiled()) {
            // bring the content to boil
            boiled = true;
        }
    }

    public boolean isEmpty() {
        return empty;
    }

    public boolean isBoiled() {
        return boiled;
    }
}
