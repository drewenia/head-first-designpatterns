package DecoratorPattern.Example01;

public abstract class ToppingDecorator implements Pizza{
    protected Pizza tempPizza;

    public ToppingDecorator(Pizza pizza) {
        this.tempPizza = pizza;
    }

    @Override
    public String getDescription() {
        return tempPizza.getDescription();
    }

    @Override
    public double getCost() {
        return tempPizza.getCost();
    }
}
