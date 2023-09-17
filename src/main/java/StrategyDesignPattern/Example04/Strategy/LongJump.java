package StrategyDesignPattern.Example04.Strategy;

public class LongJump implements JumpBehavior{
    @Override
    public void jump() {
        System.out.println("Long Jump");
    }
}
