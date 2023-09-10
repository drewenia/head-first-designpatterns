package FactoryDesignPattern.Example03;

public class App {
    public static void main(String[] args) {
        Restaurant beefRestaurant = new BeefBurgerRestaurant();
        Burger beefBurger = beefRestaurant.orderBurger();

        Restaurant veggieRestaurant = new VeggieBurgerRestaurant();
        Burger veggieBurger = veggieRestaurant.orderBurger();
    }
}
