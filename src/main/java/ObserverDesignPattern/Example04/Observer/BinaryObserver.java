package ObserverDesignPattern.Example04.Observer;

import ObserverDesignPattern.Example04.Subject.Subject;

public class BinaryObserver implements Observer{
    Subject subject;

    public BinaryObserver(Subject subject) {
        this.subject = subject;
        subject.attach(this);
    }

    @Override
    public void update() {
        System.out.println("Binary String " + Integer.toBinaryString(subject.getState()));
    }
}
