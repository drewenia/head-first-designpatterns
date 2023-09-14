package ObserverDesignPattern.Example06.Observer;

import ObserverDesignPattern.Example06.Message;

public interface Observer {
    void update(Message message);
}
