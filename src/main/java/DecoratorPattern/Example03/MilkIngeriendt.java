package DecoratorPattern.Example03;

public class MilkIngeriendt extends CoffeeDecorator{

    Coffee coffee;

    public MilkIngeriendt(Coffee coffee) {
        this.coffee = coffee;
    }

    @Override
    public double cost() {
        return coffee.cost() + .50;
    }

    @Override
    public String getDescription() {
        return coffee.getDescription() + " with Milk ingredient";
    }
}
