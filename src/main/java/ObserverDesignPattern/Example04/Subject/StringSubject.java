package ObserverDesignPattern.Example04.Subject;

import ObserverDesignPattern.Example04.Observer.Observer;

import java.util.ArrayList;
import java.util.List;

public class StringSubject implements Subject{
    private final List<Observer> observers;
    private int state;

    public StringSubject() {
        this.observers = new ArrayList<>();
    }

    @Override
    public void attach(Observer observer) {
        observers.add(observer);
    }

    @Override
    public void detach(Observer observer) {
        int index = observers.indexOf(observer);
        if (index>=0){
            observers.remove(observer);
        }
    }

    @Override
    public void notifyObserver() {
        observers.forEach(Observer::update);
    }

    @Override
    public int getState() {
        return state;
    }

    public void setState(int state) {
        this.state = state;
        notifyObserver();
    }
}
