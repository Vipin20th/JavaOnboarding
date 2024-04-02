package designPatterns.fourthTask;

public class Main {

    public static void main(String[] args) {
        // Create a basic webpage
        WebPage basicWebPage = new BasicWebPage(0);

        // Add widgets to the webpage
        WebPage mobilePage = new MobileWidget(basicWebPage);
        WebPage desktopPage = new DesktopWidget(basicWebPage);
        WebPage socialMediaPage = new SocialMediaWidget(basicWebPage);

        // Calculate rank of each page
        System.out.println("Rank of Mobile Page: " + mobilePage.getRank());
        System.out.println("Rank of Desktop Page: " + desktopPage.getRank());
        System.out.println("Rank of Social Media Page: " + socialMediaPage.getRank());
    }
}
