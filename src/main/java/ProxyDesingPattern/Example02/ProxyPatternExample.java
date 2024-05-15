package ProxyDesingPattern.Example02;

public class ProxyPatternExample {
    public static void main(String[] args) {
        Image image = new ProxyImage("Image.jpg");
        image.display();
        image.display();
    }
}
