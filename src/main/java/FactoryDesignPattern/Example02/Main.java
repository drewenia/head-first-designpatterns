package FactoryDesignPattern.Example02;

public class Main {
    public static void main(String[] args) {
        MotorVehicleFactory factory = new MotorcycleFactory();
        MotorVehicle motorcycle = factory.create();
        motorcycle.build();
    }
}
