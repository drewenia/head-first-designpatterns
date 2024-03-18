package StatePattern.Example02;

public class ProductSelectedState implements VendingMachineState{
    @Override
    public void handleRequest() {
        System.out.println("Product selected state : Processing Payment");
    }
}
