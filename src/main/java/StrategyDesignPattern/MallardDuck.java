package StrategyDesignPattern;

public class MallardDuck extends Duck{

    /* Tabii, MallardDuck sınıfı, quackBehavior ve flyBehavior instance variable'larını Duck sınıfından miras alır.*/

    public MallardDuck() {

        /* Bir MallardDuck, quack (ötüş) işlemini yönetmek için Quack sınıfını kullanır, bu nedenle performQuack
        çağrıldığında, quack (ötüş) sorumluluğu Quack nesnesine devredilir ve gerçek bir quack (ötüş) elde edilir.
        Ayrıca fly behavior türü olarak FlyWithWings kullanır.*/

        quackBehavior = new Quack();
        flyBehavior = new FlyWithWings();

    }

    @Override
    public void display() {
        System.out.println("I am real Mallard Duck");
    }
}
