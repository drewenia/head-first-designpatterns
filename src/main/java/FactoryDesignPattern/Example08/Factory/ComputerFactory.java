package FactoryDesignPattern.Example08.Factory;

import FactoryDesignPattern.Example08.Computer;

public class ComputerFactory {
    public static Computer getFactory(ComputerAbstractFactory factory){
        return factory.createComputer();
    }
}
