package FactoryDesignPattern.Example02;

public class MotorcycleFactory extends MotorVehicleFactory{
    @Override
    protected MotorVehicle createMotorVehicle() {
        return new MotorCycle();
    }
}
