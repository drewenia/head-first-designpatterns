package CompoundPatterns;

public class GooseFactory extends AbstractGooseFactory {
    @Override
    Quackable createGoose() {
        return new GooseAdapter(new Goose());
    }
}
