package ObserverDesignPattern.HeadFirstObserverDesignPattern;

/* Bu display elemanı Observer interface'ini implement eder, böylece WeatherData nesnesinden değişiklikleri alabilir.
Aynı zamanda DisplayElement interface'ini de implement eder, çünkü API'miz tüm display elemanlarının bu implemente
etmesini gerektirecek şekildedir.*/
public class CurrentConditionDisplay implements Observer, DisplayElement{

    private float temperature;
    private float humiditiy;
    private Subject weatherData;

    public CurrentConditionDisplay(Subject weatherData) {

        /* constructor'a weatherData nesnesi (Subject) geçilir ve bunu display'i bir observer olarak register için
        kullanırız.*/
        this.weatherData = weatherData;
        weatherData.registerObserver(this);
    }

    @Override
    public void display() {
        /* display() methodu sadece en son sıcaklık ve nem değerlerini yazdırır. */
        System.out.println("Current conditions: " + temperature + "F degrees and " + humiditiy + "% humidity");
    }

    @Override
    public void update(float temperature, float humidity, float pressure) {
        /* update() çağrıldığında sıcaklığı ve nemini kaydediyoruz ve display() methodunu çağırıyoruz.*/
        this.temperature = temperature;
        this.humiditiy = humidity;
        display();
    }
}
