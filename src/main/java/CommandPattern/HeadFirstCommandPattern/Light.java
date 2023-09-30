package CommandPattern.HeadFirstCommandPattern;

public class Light {

    private final String name;

    public Light(String name) {
        this.name = name;
    }

    public void on(){
        System.out.println("turn on the light");
    }

    public void off() {
        System.out.println("turn off the light");
    }
}
