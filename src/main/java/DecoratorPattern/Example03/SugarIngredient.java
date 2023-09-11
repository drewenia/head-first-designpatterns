package DecoratorPattern.Example03;

public class SugarIngredient extends CoffeeDecorator{

    Coffee coffee;

    public SugarIngredient(Coffee coffee) {
        this.coffee = coffee;
    }

    @Override
    public double cost() {
        return coffee.cost() + .70;
    }

    @Override
    public String getDescription() {
        return coffee.getDescription() + " with sugar";
    }
}
