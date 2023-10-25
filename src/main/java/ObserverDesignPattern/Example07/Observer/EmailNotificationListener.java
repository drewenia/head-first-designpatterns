package ObserverDesignPattern.Example07.Observer;

import java.io.File;

public class EmailNotificationListener implements EventListener{
    private final String email;

    public EmailNotificationListener(String email) {
        this.email = email;
    }

    @Override
    public void update(String eventType, File file) {
        System.out.println("Email to " + email + ": Someone has performed " + eventType);
    }
}
