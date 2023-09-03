package DecoratorPattern.Example01;

public class TomatoSauce extends ToppingDecorator{
    public TomatoSauce(Pizza pizza) {
        super(pizza);
    }

    @Override
    public String getDescription() {
        return tempPizza.getDescription() + " ,Tomato Sauce";
    }

    @Override
    public double getCost() {
        return tempPizza.getCost() + .40;
    }
}
