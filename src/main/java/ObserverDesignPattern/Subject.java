package ObserverDesignPattern;

public interface Subject {

    /* Her iki method da bir Observer'i argüman olarak alır; yani, register edilecek veya remove edilecek olan
    Observer'i temsil eder.*/
    void registerObserver(Observer o);
    void removeObserver(Observer o);

    /* Bu method, Subject'in state'i değiştiğinde tüm observer'lara bildirimde bulunmak için çağrılır.*/
    void notifyObservers();
}
