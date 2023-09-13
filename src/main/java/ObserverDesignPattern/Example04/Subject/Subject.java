package ObserverDesignPattern.Example04.Subject;

import ObserverDesignPattern.Example04.Observer.Observer;

public interface Subject {
    void attach(Observer observer);

    void detach(Observer observer);

    void notifyObserver();

    int getState();
}
