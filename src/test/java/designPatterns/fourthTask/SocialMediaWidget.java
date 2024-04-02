package designPatterns.fourthTask;

public class SocialMediaWidget extends WebPageDecorator {
    private static final int RANK = 3; // Rank associated with social media widget

    public SocialMediaWidget(WebPage webPage) {
        super(webPage);
    }

    @Override
    public int getRank() {
        return super.getRank() + RANK;
    }
}
