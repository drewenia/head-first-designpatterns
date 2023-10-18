package AdapterAndFacadeDesignPattern.Example03;

import AdapterAndFacadeDesignPattern.Example03.Adapter.BirdAdapter;
import AdapterAndFacadeDesignPattern.Example03.TargetInterface.PlasticToyDuck;
import AdapterAndFacadeDesignPattern.Example03.TargetInterface.ToyDuck;

public class App {
    public static void main(String[] args) {
        Sparrow sparrow = new Sparrow();
        ToyDuck toyDuck = new PlasticToyDuck();

        ToyDuck birdAdapter = new BirdAdapter(sparrow);

        System.out.println("Sparrow...");
        sparrow.fly();
        sparrow.makeSound();

        System.out.println("-----------");
        System.out.println("Toyduck...");
        toyDuck.squeak();

        System.out.println("-----------");
        System.out.println("BirdAdapter...");
        birdAdapter.squeak();
    }
}
