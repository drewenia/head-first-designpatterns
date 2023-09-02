package ObserverDesignPattern.Example02;

public class StockObserver implements Observer{
    private double ibmPrice;
    private double applePrice;
    private double googlePrice;

    private final Subject stockGrabber;

    public StockObserver(Subject stockGrabber) {
        this.stockGrabber = stockGrabber;
        stockGrabber.registerObserver(this);
    }

    @Override
    public void update(double ibmPrice, double applePrice, double googlePrice) {
        this.ibmPrice = ibmPrice;
        this.applePrice = applePrice;
        this.googlePrice = googlePrice;
        printPrices();
    }

    private void printPrices() {
        System.out.println("Ibm : " + ibmPrice + " Apple : " + applePrice + " Google : " + googlePrice);
    }
}
