package FactoryDesignPattern.Example04.Product;

public class MsiGpu implements Gpu{
    @Override
    public void assemble() {
        System.out.println("Prepared MSI Gpu");
    }
}
