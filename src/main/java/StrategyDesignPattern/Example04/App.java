package StrategyDesignPattern.Example04;

import StrategyDesignPattern.Example04.Context.Fighter;
import StrategyDesignPattern.Example04.Strategy.JumpBehavior;
import StrategyDesignPattern.Example04.Strategy.KickBehavior;
import StrategyDesignPattern.Example04.Strategy.ShortJump;
import StrategyDesignPattern.Example04.Strategy.TornadoKick;

public class App {
    public static void main(String[] args) {
        JumpBehavior shortJump = new ShortJump();
        KickBehavior tornadoKick = new TornadoKick();

        Fighter ken = new Ken(tornadoKick,shortJump);
        ken.display();
    }
}
