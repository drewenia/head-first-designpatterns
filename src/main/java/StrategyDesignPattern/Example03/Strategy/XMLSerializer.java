package StrategyDesignPattern.Example03.Strategy;

public class XMLSerializer implements SerializableBehaviour{
    @Override
    public void deSerialize(String str) {
        System.out.println("Deserialize : " + str);
    }

    @Override
    public void serialize(String str) {
        System.out.println("Serialize : " + str);
    }
}
