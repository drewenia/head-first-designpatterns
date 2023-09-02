package ObserverDesignPattern.Example02;

public class GrabApp {
    public static void main(String[] args) {
        StockGrabber stockGrabber = new StockGrabber();
        Observer stockObserver = new StockObserver(stockGrabber);

        stockGrabber.setIbmPrice(197);
        stockGrabber.setApplePrice(243);
        stockGrabber.setGooglePrice(297);
    }
}
