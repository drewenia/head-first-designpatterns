package ObserverDesignPattern.HeadFirstObserverDesignPattern;

import java.util.ArrayList;

public class WeatherData implements Subject { // Subject interface'ini implements ettik
    private final ArrayList<Observer> observers;
    private float temperature;
    private float humidity;
    private float pressure;

    public WeatherData() {
        /* Observer'ları tutmak için bir ArrayList ekledik ve bunu constructor'da oluşturuyoruz.*/
        observers = new ArrayList<>();
    }

    @Override
    public void registerObserver(Observer o) {
        /* Bir observer register edildiğinde, onu sadece listenin sonuna ekleriz. */
        observers.add(o);
    }

    @Override
    public void removeObserver(Observer o) {
        /* Benzer şekilde, bir observer remove edilmek istediğinizde, onu sadece listeden çıkarırız. */
        int i = observers.indexOf(o);
        if (i >= 0)
            observers.remove(i);
    }

    @Override
    public void notifyObservers() {
        /* Burada tüm observer'lara state hakkında bilgi veriyoruz. Hepsi Observer olduğu için, hepsinin update()
        methodunu implements ettiğini biliyoruz, bu nedenle onlara nasıl bildirim yapacağımızı biliyoruz.*/
        observers.forEach(observer -> observer.update(temperature, humidity, pressure));
    }

    public void measurementChanged() {
        /* Weather Station'dan güncellenmiş ölçümleri aldığımızda Observer'ları bilgilendiriyoruz.*/
        notifyObservers();
    }

    public void setMeasurement(float temperature, float humidity, float pressure) {
        /* Tamam, her kitapla güzel bir Weather Statin göndermek istedik, ancak yayıncı buna sıcak bakmadı. Bu nedenle,
        cihazdan gerçek hava verileri okumak yerine, bu methodu kullanarak display elemanlarımızı test etmeye karar
        verdik */
        this.temperature = temperature;
        this.humidity = humidity;
        this.pressure = pressure;
        measurementChanged();
    }
}
