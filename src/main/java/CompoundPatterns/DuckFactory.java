package CompoundPatterns;

public class DuckFactory extends AbstractDuckFactory{
    /* Her method bir Product yaratır: belirli bir Quackable type'ı. Gerçek product simülatör tarafından bilinmez -
    sadece bir Quackableß elde ettiğini bilir.*/
    @Override
    Quackable createMallardDuck() {
        return new MallardDuck();
    }

    @Override
    Quackable createRedHeadDuck() {
        return new RedHeadDuck();
    }

    @Override
    Quackable createDuckCall() {
        return new DuckCall();
    }

    @Override
    Quackable createRubberDuck() {
        return new RubberDuck();
    }
}
