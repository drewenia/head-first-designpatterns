package CompoundPatterns;

public class CountingFactory extends AbstractDuckFactory{

    /* Her method Quackable'ı quack count decorator'ı ile wrap eder. Simülatör aradaki farkı asla bilemez; sadece bir
    Quackable geri alır. Ancak artık bekçilerimiz tüm quack'ların sayıldığından emin olabilirler.*/
    @Override
    Quackable createMallardDuck() {
        return new QuackCounter(new MallardDuck());
    }

    @Override
    Quackable createRedHeadDuck() {
        return new QuackCounter(new RedHeadDuck());
    }

    @Override
    Quackable createDuckCall() {
        return new QuackCounter(new DuckCall());
    }

    @Override
    Quackable createRubberDuck() {
        return new QuackCounter(new RubberDuck());
    }
}
