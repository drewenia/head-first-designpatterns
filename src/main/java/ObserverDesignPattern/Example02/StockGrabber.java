package ObserverDesignPattern.Example02;

import java.util.ArrayList;

public class StockGrabber implements Subject{

    private final ArrayList<Observer> observers;
    private double ibmPrice;
    private double applePrice;
    private double googlePrice;

    public StockGrabber(){
        observers = new ArrayList<>();
    }

    @Override
    public void registerObserver(Observer observer) {
        observers.add(observer);
    }

    @Override
    public void removeObserver(Observer observer) {
        int removeIndex = observers.indexOf(observer);
        if (removeIndex >=0)
            observers.remove(observer);
    }

    @Override
    public void notifyObserver() {
        observers.forEach(observer-> observer.update(ibmPrice,applePrice,googlePrice));
    }

    public void setIbmPrice(double ibmPrice){
        this.ibmPrice = ibmPrice;
        notifyObserver();
    }

    public void setApplePrice(double applePrice) {
        this.applePrice = applePrice;
        notifyObserver();
    }

    public void setGooglePrice(double googlePrice) {
        this.googlePrice = googlePrice;
        notifyObserver();
    }
}
