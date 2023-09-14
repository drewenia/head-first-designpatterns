package ObserverDesignPattern.Example06.Subject;

import ObserverDesignPattern.Example06.Message;
import ObserverDesignPattern.Example06.Observer.Observer;

import java.util.ArrayList;
import java.util.List;

public class ConcreteSubject implements Subject{
    private final List<Observer> observers;

    public ConcreteSubject() {
        observers = new ArrayList<>();
    }

    @Override
    public void attach(Observer observer) {
        observers.add(observer);
    }

    @Override
    public void detach(Observer observer) {
        observers.remove(observer);
    }

    @Override
    public void notify(Message message) {
        observers.forEach(observer -> observer.update(message));
    }
}
