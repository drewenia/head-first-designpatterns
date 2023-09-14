package FactoryDesignPattern.Example05;

public class VannillaMilkshake implements Milkshake{
    private final String name;

    public VannillaMilkshake() {
        this.name = MilkshakeName.VannillaMilkshake.toString();
    }
}
