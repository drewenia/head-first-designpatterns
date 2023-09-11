package DecoratorPattern.Example03;

public class App {
    public static void main(String[] args) {
        Coffee espresso = new EspressoCoffee();
        printCoffee(espresso);
        espresso = new MilkIngeriendt(espresso);
        espresso = new SugarIngredient(espresso);
        printCoffee(espresso);
    }

    private static void printCoffee(Coffee coffee) {
        System.out.println("Coffee : "  + coffee.getDescription() + " ,price " + coffee.cost());
    }
}
