package DecoratorPattern.Example03;

public class EspressoCoffee extends Coffee{

    public EspressoCoffee() {
        description = "Espresso";
    }

    @Override
    public double cost() {
        return 1.90;
    }
}
