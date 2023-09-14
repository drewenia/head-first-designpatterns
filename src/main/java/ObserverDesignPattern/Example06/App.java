package ObserverDesignPattern.Example06;

import ObserverDesignPattern.Example06.Observer.Observer;
import ObserverDesignPattern.Example06.Observer.ObserverA;
import ObserverDesignPattern.Example06.Observer.ObserverB;
import ObserverDesignPattern.Example06.Observer.ObserverC;
import ObserverDesignPattern.Example06.Subject.ConcreteSubject;
import ObserverDesignPattern.Example06.Subject.Subject;

public class App {
    public static void main(String[] args) {
        Observer a = new ObserverA();
        Observer b = new ObserverB();
        Observer c = new ObserverC();

        Subject concreteSubject = new ConcreteSubject();
        concreteSubject.attach(a);
        concreteSubject.attach(b);
        concreteSubject.attach(c);

        concreteSubject.notify(new Message("First update\n"));

        concreteSubject.detach(b);

        concreteSubject.notify(new Message("Second Update\n"));
    }
}
