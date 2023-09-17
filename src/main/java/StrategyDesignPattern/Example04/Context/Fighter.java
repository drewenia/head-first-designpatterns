package StrategyDesignPattern.Example04.Context;

import StrategyDesignPattern.Example04.Strategy.JumpBehavior;
import StrategyDesignPattern.Example04.Strategy.KickBehavior;

public abstract class Fighter {
    KickBehavior kickBehavior;
    JumpBehavior jumpBehavior;

    public Fighter(KickBehavior kickBehavior, JumpBehavior jumpBehavior) {
        this.kickBehavior = kickBehavior;
        this.jumpBehavior = jumpBehavior;
    }

    public void punch(){
        System.out.println("Default punch");
    }

    public void roll(){
        System.out.println("Default roll");
    }

    public void kick(){
        kickBehavior.kick();
    }

    public void jump(){
        jumpBehavior.jump();
    }

    public void setKickBehavior(KickBehavior kickBehavior) {
        this.kickBehavior = kickBehavior;
    }

    public void setJumpBehavior(JumpBehavior jumpBehavior) {
        this.jumpBehavior = jumpBehavior;
    }

    public abstract void display();

}
