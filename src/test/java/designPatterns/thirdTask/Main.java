package designPatterns.thirdTask;

public class Main {

    public static void main(String[] args) {
        PhoneCameraApp basicCameraApp = new PhoneCameraApp();
        basicCameraApp.setShareStrategy(new EmailShareStrategy());
        basicCameraApp.takePhoto();
        basicCameraApp.editPhoto();
        basicCameraApp.savePhoto();
        basicCameraApp.sharePhoto("photo1");

        PhoneCameraApp cameraPlusApp = new PhoneCameraApp();
        cameraPlusApp.setShareStrategy(new SocialMediaShareStrategy());
        cameraPlusApp.takePhoto();
        cameraPlusApp.editPhoto();
        cameraPlusApp.savePhoto();
        cameraPlusApp.sharePhoto("photo2");
    }
}
