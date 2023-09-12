package StrategyDesignPattern.HeadFirstStrategyDesignPattern;

public class ModelDuckTest {
    public static void main(String[] args) {
        Duck modelDuck = new ModelDuck();

        /* performFly() metoduna yapılan ilk çağrı, ModelDuck'ın constructor metodunda ayarlanan flyBehavior nesnesine
        devreder, bu nesne bir FlyNoWay instance'idir.*/
        modelDuck.performFly();

        modelDuck.performQuack();

        /* Bu, modelin miras alınmış behavior setter methodunu çağırır ve... işte! Model aniden roketle güçlendirilmiş
        fly yeteneğine sahip olur!*/
        modelDuck.setFlyBehavior(new FlyRocketPowered());
        modelDuck.performFly();

        /* Eğer işe yararsa, model Duck dinamik olarak fly behavior'unu değiştirdi! Eğer implementasyon Duck sınıfının i
        çinde bulunuyorsa BUNU yapamazsınız.*/
    }
}
