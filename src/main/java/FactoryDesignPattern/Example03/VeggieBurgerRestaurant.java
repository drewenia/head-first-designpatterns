package FactoryDesignPattern.Example03;

public class VeggieBurgerRestaurant extends Restaurant{
    @Override
    public Burger createBurger() {
        return new VeggieBurger();
    }
}
