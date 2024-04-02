package designPatterns.thirdTask;

public class SocialMediaShareStrategy implements ShareStrategy {
    @Override
    public void share(String photo) {
        // Logic to share photo via social media
        System.out.println("Sharing photo via social media: " + photo);
    }
}
