package StrategyDesignPattern.Example03.Strategy;

public class BinarySerializer implements SerializableBehaviour{
    @Override
    public void deSerialize(String str) {
        System.out.println("Binary deserialize : " + str);
    }

    @Override
    public void serialize(String str) {
        System.out.println("Binary serialize : " + str);
    }
}
