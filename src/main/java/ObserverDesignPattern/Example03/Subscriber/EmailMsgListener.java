package ObserverDesignPattern.Example03.Subscriber;

import ObserverDesignPattern.Example03.Event;

public record EmailMsgListener (String email) implements Listener {
    @Override
    public void update(Event eventType) {
        System.out.println("Sending mail to " + email + " concerning " + eventType);
    }
}
