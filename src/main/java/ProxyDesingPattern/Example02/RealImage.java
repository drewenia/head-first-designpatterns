package ProxyDesingPattern.Example02;

public class RealImage implements Image{

    private final String fileName;

    public RealImage(String fileName) {
        this.fileName = fileName;
        loadingImageFromDisk();
    }

    private void loadingImageFromDisk(){
        System.out.println("Loading image : " + fileName);
    }

    @Override
    public void display() {
        System.out.println("Displaying image : " + fileName);
    }
}
