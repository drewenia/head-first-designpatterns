package DecoratorPattern.Example06;

public interface DataSource {
    void writeData(String data);

    String readData();
}
