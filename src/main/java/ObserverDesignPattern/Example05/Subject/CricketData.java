package ObserverDesignPattern.Example05.Subject;

import ObserverDesignPattern.Example05.Observer.Observer;

import java.util.ArrayList;

public class CricketData implements Subject{

    int runs,wickets;
    float overs;

    private final ArrayList<Observer> observers;

    public CricketData() {
        this.observers = new ArrayList<>();
    }

    @Override
    public void registerObserver(Observer o) {
        observers.add(o);
    }

    @Override
    public void unregisterObserver(Observer o) {
        int index = observers.indexOf(o);
        if (index>=0)
            observers.remove(o);
    }

    @Override
    public void notifyObservers() {
        observers.forEach(observer-> observer.update(runs,wickets,overs));
    }

    public void dataChanged(int runs, int wickets, float overs){
        this.runs = runs;
        this.wickets = wickets;
        this.overs = overs;
        notifyObservers();
    }
}
