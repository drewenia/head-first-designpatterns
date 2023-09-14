package FactoryDesignPattern.Example05;

public class ButterscotchMilkshake implements Milkshake{
    private final String name;

    public ButterscotchMilkshake() {
        this.name = MilkshakeName.ButterscotchMilkshake.toString();
    }
}
