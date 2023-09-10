package FactoryDesignPattern.Example03;

public class BeefBurgerRestaurant extends Restaurant{
    @Override
    public Burger createBurger() {
        return new BeefBurger();
    }
}
