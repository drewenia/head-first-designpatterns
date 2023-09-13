package ObserverDesignPattern.Example05;

import ObserverDesignPattern.Example05.Observer.AverageScoreDisplay;
import ObserverDesignPattern.Example05.Observer.CurrentScoreDisplay;
import ObserverDesignPattern.Example05.Subject.CricketData;

public class App {
    public static void main(String[] args) {
        CricketData subject = new CricketData();
        subject.registerObserver(new AverageScoreDisplay());
        subject.registerObserver(new CurrentScoreDisplay());
        subject.dataChanged(20, 5, 11);
    }
}
