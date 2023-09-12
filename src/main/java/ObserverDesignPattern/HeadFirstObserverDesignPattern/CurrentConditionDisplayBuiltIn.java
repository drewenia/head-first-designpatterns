package ObserverDesignPattern.HeadFirstObserverDesignPattern;

import java.util.Observable;
import java.util.Observer;

public class CurrentConditionDisplayBuiltIn implements Observer, DisplayElement {

    Observable observable;
    private float temperature;
    private float humidity;

    public CurrentConditionDisplayBuiltIn(Observable observable) {

        /* Constructor method artık bir Observable alır ve bu Observable'ı kullanarak CurrentConditionDisplayBuiltIn
        nesnesini bir Observer olarak ekleriz.*/

        this.observable = observable;
        observable.addObserver(this);
    }

    @Override
    public void display() {
        System.out.println("Current conditions : " + temperature + "F degrees and " + humidity + "% humidity");
    }

    @Override
    public void update(Observable o, Object arg) {

        /* update() methodunu, hem bir Observable hem de isteğe bağlı veri argümanını kabul edecek şekilde
        değiştirdik.*/

        /* update() methodunda önce observable'ın WeatherData türünde olduğundan emin oluruz ve ardından sıcaklık ve
        nem ölçümlerini almak için getter methodlarını kullanırız. Bundan sonra display() methodunu çağırırız.*/

        if (o instanceof WeatherDataBuiltIn weatherData){
            this.temperature = weatherData.getTemperature();
            this.humidity = weatherData.getHumidity();
            display();
        }
    }
}
