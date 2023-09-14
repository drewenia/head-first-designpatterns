package ObserverDesignPattern.Example06.Observer;

import ObserverDesignPattern.Example06.Message;

public class ObserverA implements Observer{
    @Override
    public void update(Message message) {
        System.out.println("observerA : " + message.getMessage());
    }
}
