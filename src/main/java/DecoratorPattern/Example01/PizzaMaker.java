package DecoratorPattern.Example01;

public class PizzaMaker {
    public static void main(String[] args) {
        Pizza basicPizza = new TomatoSauce(new Mozzarella(new PlainPizza()));
        System.out.println("Ingeridient : " + basicPizza.getDescription());
        System.out.println("Price : " + basicPizza.getCost());
    }
}
