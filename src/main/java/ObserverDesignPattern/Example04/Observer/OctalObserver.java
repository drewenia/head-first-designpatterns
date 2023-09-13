package ObserverDesignPattern.Example04.Observer;

import ObserverDesignPattern.Example04.Subject.Subject;

public class OctalObserver implements Observer{
    Subject subject;

    public OctalObserver(Subject subject) {
        this.subject = subject;
        subject.attach(this);
    }

    @Override
    public void update() {
        System.out.println("Octal String: " + Integer.toOctalString(subject.getState()));
    }
}
