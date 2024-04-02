package designPatterns.fourthTask;

public class MobileWidget extends WebPageDecorator {
    private static final int RANK = 1; // Rank associated with mobile version

    public MobileWidget(WebPage webPage) {
        super(webPage);
    }

    @Override
    public int getRank() {
        return super.getRank() + RANK;
    }
}
