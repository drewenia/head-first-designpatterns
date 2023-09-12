package ObserverDesignPattern.HeadFirstObserverDesignPattern;

public interface Observer {

    /* Bunlar, bir hava ölçümü değiştiğinde Observer'ların Subject'e ait aldığı state değerleridir.*/
    void update(float temperature, float humidity, float pressure);
}
