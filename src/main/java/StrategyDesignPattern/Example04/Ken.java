package StrategyDesignPattern.Example04;

import StrategyDesignPattern.Example04.Context.Fighter;
import StrategyDesignPattern.Example04.Strategy.JumpBehavior;
import StrategyDesignPattern.Example04.Strategy.KickBehavior;

public class Ken extends Fighter {
    public Ken(KickBehavior kickBehavior, JumpBehavior jumpBehavior) {
        super(kickBehavior, jumpBehavior);
    }

    @Override
    public void display() {
        System.out.println("Ken");
    }
}
