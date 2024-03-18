package StatePattern.Example02;

public class Main {
    public static void main(String[] args) {
        VendingMachineContext vendingMachineContext = new VendingMachineContext();
        vendingMachineContext.setState(new ReadyState());
        vendingMachineContext.request();

        vendingMachineContext.setState(new ProductSelectedState());
        vendingMachineContext.request();

        vendingMachineContext.setState(new PaymentPendingState());
        vendingMachineContext.request();

        vendingMachineContext.setState(new OutOfStockState());
        vendingMachineContext.request();
    }
}
