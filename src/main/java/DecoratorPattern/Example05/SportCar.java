package DecoratorPattern.Example05;

public class SportCar extends CarDecorator{
    public SportCar(Car car) {
        super(car);
    }

    @Override
    public void assemble() {
        super.assemble();
        System.out.print(" Adding features of Sports Car");
    }
}
