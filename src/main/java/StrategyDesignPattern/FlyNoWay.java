package StrategyDesignPattern;

public class FlyNoWay implements FlyBehavior{
    @Override
    public void fly() {
        System.out.println("i am not flying");
    }
}
