package StrategyDesignPattern.HeadFirstStrategyDesignPattern;

public class ModelDuck extends Duck{

    public ModelDuck() {
        flyBehavior = new FlyNoWay();
        quackBehavior = new Quack();
    }

    @Override
    public void display() {
        System.out.println("i am a model duck");
    }
}
