package AdapterAndFacadeDesignPattern.Example03.Adapter;

import AdapterAndFacadeDesignPattern.Example03.Adaptee.Bird;
import AdapterAndFacadeDesignPattern.Example03.TargetInterface.ToyDuck;

public class BirdAdapter implements ToyDuck {
    Bird bird;

    public BirdAdapter(Bird bird) {
        this.bird = bird;
    }

    @Override
    public void squeak() {
        bird.makeSound();
    }
}
