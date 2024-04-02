package designPatterns.thirdTask;

public class EmailShareStrategy implements ShareStrategy {
    @Override
    public void share(String photo) {
        // Logic to share photo via email
        System.out.println("Sharing photo via email: " + photo);
    }
}
