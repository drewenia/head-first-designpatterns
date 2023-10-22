package AdapterAndFacadeDesignPattern.Example07;

public class Ceo implements ExecutiveEmployee{
    @Override
    public String getFullTitleAndName() {
        return "John Doe, CEO";
    }
}
