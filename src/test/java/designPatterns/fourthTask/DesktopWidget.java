package designPatterns.fourthTask;

public class DesktopWidget extends WebPageDecorator {
    private static final int RANK = 2; // Rank associated with desktop version

    public DesktopWidget(WebPage webPage) {
        super(webPage);
    }

    @Override
    public int getRank() {
        return super.getRank() + RANK;
    }
}