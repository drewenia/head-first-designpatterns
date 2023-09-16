package StrategyDesignPattern.Example03.Context;

import StrategyDesignPattern.Example03.Strategy.SerializableBehaviour;

public class Context {
    SerializableBehaviour serializableBehaviour;

    public Context(SerializableBehaviour serializableBehaviour) {
        this.serializableBehaviour = serializableBehaviour;
    }

    public void serialize(String str){
        serializableBehaviour.serialize(str);
    }

    public void deSerialize(String str){
        serializableBehaviour.deSerialize(str);
    }
}
