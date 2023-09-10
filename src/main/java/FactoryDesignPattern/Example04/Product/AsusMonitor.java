package FactoryDesignPattern.Example04.Product;

public class AsusMonitor implements Monitor{
    @Override
    public void assemble() {
        System.out.println("Prepared Asus Monitor");
    }
}
