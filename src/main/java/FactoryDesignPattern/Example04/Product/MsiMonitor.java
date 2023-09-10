package FactoryDesignPattern.Example04.Product;

public class MsiMonitor implements Monitor{
    @Override
    public void assemble() {
        System.out.println("Prepared MSI Monitor");
    }
}
