package ObserverDesignPattern.HeadFirstObserverDesignPattern;

public class StatisticDisplay implements Observer, DisplayElement {
    private Subject weatherData;
    private float temperature;
    private float humidity;
    private float pressure;

    public StatisticDisplay(Subject weatherData) {
        this.weatherData = weatherData;
        weatherData.registerObserver(this);
    }

    @Override
    public void update(float temperature, float humidity, float pressure) {
        this.temperature = temperature;
        this.humidity = humidity;
        this.pressure = pressure;
        display();
    }

    @Override
    public void display() {
        System.out.println("Statistics display : " + temperature + " C degrees and " + humidity + " %humidity" + pressure + " pressure");
    }
}
