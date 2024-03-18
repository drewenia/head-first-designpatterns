package StatePattern.Example02;

public class PaymentPendingState implements VendingMachineState{
    @Override
    public void handleRequest() {
        System.out.println("Payment pending state: Dispensing product.");
    }
}
