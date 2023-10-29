package DecoratorPattern.Example06;

public class App {
    public static void main(String[] args) {
        String salaryRecords = "Name, Salary\nJohn Smith,100000\nSteve Jobs,912000";
        DataSourceDecorator encoded = new CompressionDecorator(
                new EncryptionDecorator(
                        new FileDataSource("OutputDemo.txt")
                )
        );

        encoded.writeData(salaryRecords);

        DataSource plainText = new FileDataSource("OutputDemo.txt");

        System.out.println("----- Input -----");
        System.out.println(salaryRecords);

        System.out.println("----- Encoded ----");
        System.out.println(plainText.readData());

        System.out.println("----- Decoded -----");
        System.out.println(encoded.readData());
    }
}
