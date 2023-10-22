package AdapterAndFacadeDesignPattern.Example07;

public class Engineer implements Employee{
    @Override
    public String getJobTitle() {
        return "Software Engineer";
    }

    @Override
    public String getName() {
        return "Jane Doe";
    }
}
