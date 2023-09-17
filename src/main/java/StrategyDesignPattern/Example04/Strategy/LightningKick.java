package StrategyDesignPattern.Example04.Strategy;

public class LightningKick implements KickBehavior {
    @Override
    public void kick() {
        System.out.println("Lightining Kick");
    }
}
