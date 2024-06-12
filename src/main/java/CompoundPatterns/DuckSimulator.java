package CompoundPatterns;

public class DuckSimulator {
    public static void main(String[] args) {
        DuckSimulator simulator = new DuckSimulator();

        AbstractDuckFactory duckFactory = new CountingFactory();
        simulator.simulate(duckFactory);
    }

    private void simulate(AbstractDuckFactory duckFactory) {
        Quackable mallardDuck = duckFactory.createMallardDuck();
        Quackable redHeadDuck = duckFactory.createRedHeadDuck();
        Quackable duckCall = duckFactory.createDuckCall();
        Quackable rubberDuck = duckFactory.createRubberDuck();

        Flock flockOfDucks = new Flock();
        flockOfDucks.add(mallardDuck);
        flockOfDucks.add(redHeadDuck);
        flockOfDucks.add(duckCall);
        flockOfDucks.add(rubberDuck);

        System.out.println("Duck simulator: With Observer");

        /* Burada yaptığımız tek şey bir Quackologist yaratmak ve onu Flock'un observer'i olarak belirlemek */
        Quackologist quackologist = new Quackologist();
        flockOfDucks.registerObserver(quackologist);

        simulate(flockOfDucks);

        System.out.println("\nThe ducks quacked " + QuackCounter.getNumberOfQuacks() + " times");

    }

    private void simulate(Quackable duck) {
        duck.quack();
    }
}
