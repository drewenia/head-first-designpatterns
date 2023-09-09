package FactoryDesignPattern.Example02;

public class MotorCycle implements MotorVehicle{
    @Override
    public void build() {
        System.out.println("Build motorcycle");
    }
}
