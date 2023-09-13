package ObserverDesignPattern.Example04.Observer;

import ObserverDesignPattern.Example04.Subject.Subject;

public class HexObserver implements Observer{
    Subject subject;

    public HexObserver(Subject subject) {
        this.subject = subject;
        subject.attach(this);
    }

    @Override
    public void update() {
        System.out.println("Hex String : " + Integer.toHexString(subject.getState()));
    }
}
