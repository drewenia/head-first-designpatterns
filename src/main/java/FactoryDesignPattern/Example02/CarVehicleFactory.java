package FactoryDesignPattern.Example02;

public class CarVehicleFactory extends MotorVehicleFactory{
    @Override
    protected MotorVehicle createMotorVehicle() {
        return new Car();
    }
}
