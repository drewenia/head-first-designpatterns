package DecoratorPattern.Example05;

public class BasicCar implements Car{
    @Override
    public void assemble() {
        System.out.print("Car : Basic Car");
    }
}
