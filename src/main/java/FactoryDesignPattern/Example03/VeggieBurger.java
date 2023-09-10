package FactoryDesignPattern.Example03;

public class VeggieBurger implements Burger {
    @Override
    public void prepare() {
        System.out.println("Veggie Burger prepared");
    }
}
