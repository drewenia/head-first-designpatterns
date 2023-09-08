package FactoryDesignPattern;

public interface PizzaIngredientFactory {
    Dough createDough(); // hamur
    Sauce createSauce(); // sos
    Cheese createCheese(); // peynir
    Veggies[] createVeggies(); // sebzeler
    Pepperoni createPepperoni(); // biberli
    Clams createClam(); // istiridye
}
