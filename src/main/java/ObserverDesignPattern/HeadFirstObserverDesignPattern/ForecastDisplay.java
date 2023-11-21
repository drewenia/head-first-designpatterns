package ObserverDesignPattern.HeadFirstObserverDesignPattern;

public class ForecastDisplay implements Observer,DisplayElement{

    private Subject weatherData;
    private float humidity;

    public ForecastDisplay(Subject weatherData) {
        this.weatherData = weatherData;
        weatherData.registerObserver(this);
    }

    @Override
    public void update(float temperature, float humidity, float pressure) {
        this.humidity = humidity;
        display();
    }

    @Override
    public void display() {
        System.out.println("Forecast : humidity : " + this.humidity);
    }
}
