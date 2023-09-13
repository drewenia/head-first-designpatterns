package ObserverDesignPattern.Example04;

import ObserverDesignPattern.Example04.Observer.BinaryObserver;
import ObserverDesignPattern.Example04.Observer.HexObserver;
import ObserverDesignPattern.Example04.Observer.Observer;
import ObserverDesignPattern.Example04.Observer.OctalObserver;
import ObserverDesignPattern.Example04.Subject.StringSubject;

public class App {
    public static void main(String[] args) {
        StringSubject subject = new StringSubject();
        Observer binaryObserver = new BinaryObserver(subject);
        Observer octalObserver = new OctalObserver(subject);
        Observer hexObserver = new HexObserver(subject);
        subject.detach(octalObserver);
        subject.setState(34);
    }
}
