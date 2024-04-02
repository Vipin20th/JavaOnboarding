package designPatterns.thirdTask;

public class TextShareStrategy implements ShareStrategy {
    @Override
    public void share(String photo) {
        // Logic to share photo via text
        System.out.println("Sharing photo via text: " + photo);
    }
}
