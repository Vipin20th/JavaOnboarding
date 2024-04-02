package designPatterns.fourthTask;

public abstract class WebPageDecorator implements WebPage {
    private WebPage webPage;

    public WebPageDecorator(WebPage webPage) {
        this.webPage = webPage;
    }

    @Override
    public int getRank() {
        return webPage.getRank();
    }
}
