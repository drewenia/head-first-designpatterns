package StrategyDesignPattern.Example04.Strategy;

public class ShortJump implements JumpBehavior{
    @Override
    public void jump() {
        System.out.println("Short Jump");
    }
}
