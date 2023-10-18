package AdapterAndFacadeDesignPattern.Example03.TargetInterface;

public class PlasticToyDuck implements ToyDuck{
    @Override
    public void squeak() {
        System.out.println("Squeak");
    }
}
