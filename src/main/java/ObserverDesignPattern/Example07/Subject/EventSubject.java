package ObserverDesignPattern.Example07.Subject;

import ObserverDesignPattern.Example07.Observer.EventListener;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class EventSubject {
    Map<String, List<EventListener>> listeners = new HashMap<>();

    public EventSubject(String... operations) {
        for(String operation : operations){
            this.listeners.put(operation,new ArrayList<>());
        }
    }

    public void subscribe(String eventType,EventListener listener){
        List<EventListener> users = listeners.get(eventType);
        users.add(listener);
    }

    public void unSubscribe(String eventType,EventListener listener){
        List<EventListener> users = listeners.get(eventType);
        users.remove(listener);
    }

    public void notify(String eventType, File file){
        List<EventListener> users = listeners.get(eventType);
        users.forEach(user-> user.update(eventType,file));
    }
}
