package FactoryDesignPattern.Example02;

public class Car implements MotorVehicle{
    @Override
    public void build() {
        System.out.println("Build Car");
    }
}
