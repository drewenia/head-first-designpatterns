package ObserverDesignPattern.Example03.Subscriber;

import ObserverDesignPattern.Example03.Event;

public record MobileAppListener (String username) implements Listener {

    @Override
    public void update(Event eventType) {
        System.out.println("Sending mobile app notification to " + username + " concerning" + eventType);
    }
}
