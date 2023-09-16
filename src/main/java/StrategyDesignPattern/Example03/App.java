package StrategyDesignPattern.Example03;

import StrategyDesignPattern.Example03.Context.Context;
import StrategyDesignPattern.Example03.Strategy.BinarySerializer;
import StrategyDesignPattern.Example03.Strategy.XMLSerializer;

public class App {
    public static void main(String[] args) {
        Context context = new Context(new XMLSerializer());
        context.serialize("Strategy");
        context.deSerialize("Pattern");

        context = new Context(new BinarySerializer());
        context.serialize("Design");
        context.deSerialize("Example");
    }
}
