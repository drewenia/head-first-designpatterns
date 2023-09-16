package StrategyDesignPattern.Example03.Strategy;

public interface SerializableBehaviour {
    void deSerialize(String str);

    void serialize(String str);
}
