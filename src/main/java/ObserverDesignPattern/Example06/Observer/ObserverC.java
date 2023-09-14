package ObserverDesignPattern.Example06.Observer;

import ObserverDesignPattern.Example06.Message;

public class ObserverC implements Observer{
    @Override
    public void update(Message message) {
        System.out.println("observerC : " + message.getMessage());
    }
}
