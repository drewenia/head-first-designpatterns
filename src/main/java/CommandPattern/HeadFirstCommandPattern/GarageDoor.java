package CommandPattern.HeadFirstCommandPattern;

public class GarageDoor {
    private final String name;

    public GarageDoor(String name) {
        this.name = name;
    }

    public void open() {
        System.out.println("Garage door is Open");
    }

    public void close() {
        System.out.println("Garage door is Close");
    }
}
