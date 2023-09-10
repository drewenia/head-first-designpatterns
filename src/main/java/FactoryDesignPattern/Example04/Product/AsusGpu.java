package FactoryDesignPattern.Example04.Product;

public class AsusGpu implements Gpu{
    @Override
    public void assemble() {
        System.out.println("Prepared Asus GPU");
    }
}
