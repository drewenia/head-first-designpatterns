package ObserverDesignPattern.Example01;

import java.util.ArrayList;
import java.util.List;

public class NewsSubject {
    private String news;

    private List<Observer> observers;

    public NewsSubject() {
        observers = new ArrayList<>();
    }

    public void addObserver(Observer observer){
        this.observers.add(observer);
    }

    public void removeObserver(Observer observer){
        this.observers.remove(observer);
    }

    public void setNews(String news){
        this.news = news;
        observers.forEach(observer-> observer.update(this.news));
    }
}
