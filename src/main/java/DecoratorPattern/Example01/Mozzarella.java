package DecoratorPattern.Example01;

public class Mozzarella extends ToppingDecorator{
    public Mozzarella(Pizza pizza) {
        super(pizza);
    }

    @Override
    public String getDescription() {
        return tempPizza.getDescription() + " ,Mozarella";
    }

    @Override
    public double getCost() {
        return tempPizza.getCost() + .50;
    }
}
