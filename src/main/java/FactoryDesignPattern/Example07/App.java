package FactoryDesignPattern.Example07;

public class App {
    public static void main(String[] args) {
        Computer pc = ComputerFactory.getComputer("PC", "1 GB", "256 GB", "i5 7100");
        System.out.println("Pc Config : " + pc);

        Computer server = ComputerFactory.getComputer("SERVER","4 GB","512 GB", "Xeon 7100");
        System.out.println("Server Config : " + server);
    }
}
