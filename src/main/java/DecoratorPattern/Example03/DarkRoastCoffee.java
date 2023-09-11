package DecoratorPattern.Example03;

public class DarkRoastCoffee extends Coffee{

    public DarkRoastCoffee() {
        description = "Dark Roast Coffee";
    }

    @Override
    public double cost() {
        return 1.50;
    }
}
