package ObserverDesignPattern.Example06.Subject;

import ObserverDesignPattern.Example06.Message;
import ObserverDesignPattern.Example06.Observer.Observer;

public interface Subject {
    void attach(Observer observer);

    void detach(Observer observer);

    void notify(Message message);
}
