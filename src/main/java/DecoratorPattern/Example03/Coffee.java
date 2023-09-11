package DecoratorPattern.Example03;

public abstract class Coffee {
    String description = "unknown coffee";

    public String getDescription() {
        return description;
    }

    public abstract double cost();
}
