package designPatterns.fourthTask;

public class BasicWebPage implements WebPage {
    private int rank;

    public BasicWebPage(int rank) {
        this.rank = rank;
    }

    @Override
    public int getRank() {
        return rank;
    }
}
