package ObserverDesignPattern.Example03.Subscriber;

import ObserverDesignPattern.Example03.Event;

public interface Listener {
    void update(Event eventType);
}
