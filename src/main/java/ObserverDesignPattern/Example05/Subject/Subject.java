package ObserverDesignPattern.Example05.Subject;

import ObserverDesignPattern.Example05.Observer.Observer;

public interface Subject {
    void registerObserver(Observer o);
    void unregisterObserver(Observer o);
    void notifyObservers();
}
