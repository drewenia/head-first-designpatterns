package FactoryDesignPattern;

public class NYPizzaStore extends PizzaStore{
    @Override
    protected Pizza createPizza(String item) {
        Pizza pizza = null;
        PizzaIngredientFactory factory = new NYPizzaIngredientFactory();
        switch (item) {
            case "cheese" -> {
                pizza = new CheesePizza(factory);
                pizza.setName("New York Style Cheese Pizza");
            }
            case "veggie" -> {
                pizza = new VeggiePizza(factory);
                pizza.setName("New York Style Veggie Pizza");
            }
            case "clam" -> {
                pizza = new ClamPizza(factory);
                pizza.setName("New York Style Clam Pizza");
            }
            case "pepperoni" -> {
                pizza = new PepperoniPizza(factory);
                pizza.setName("New York Style Pepperoni Pizza");
            }
        }
        return pizza;
    }
}
