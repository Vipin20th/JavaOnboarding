package designPatterns.thirdTask;

public class PhoneCameraApp {

    private ShareStrategy shareStrategy;

    public void setShareStrategy(ShareStrategy shareStrategy) {
        this.shareStrategy = shareStrategy;
    }

    public void takePhoto() {
        // Logic to take a photo
        System.out.println("Taking a photo...");
    }

    public void editPhoto() {
        // Logic to edit a photo
        System.out.println("Editing photo...");
    }

    public void savePhoto() {
        // Logic to save a photo
        System.out.println("Saving photo...");
    }

    public void sharePhoto(String photo) {
        // Use the selected strategy to share the photo
        if (shareStrategy != null) {
            shareStrategy.share(photo);
        } else {
            System.out.println("No share strategy set.");
        }
    }
}
