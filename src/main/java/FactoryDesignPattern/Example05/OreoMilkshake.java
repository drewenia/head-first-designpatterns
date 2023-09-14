package FactoryDesignPattern.Example05;

public class OreoMilkshake implements Milkshake{
    private final String name;

    public OreoMilkshake() {
        this.name = MilkshakeName.OreoMilkshake.toString();
    }
}
