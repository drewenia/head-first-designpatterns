package FactoryDesignPattern.Example08;

import FactoryDesignPattern.Example08.Factory.ComputerFactory;
import FactoryDesignPattern.Example08.Factory.PCFactory;
import FactoryDesignPattern.Example08.Factory.ServerFactory;

public class App {
    public static void main(String[] args) {
        Computer pc = ComputerFactory.getFactory(new PCFactory("4 GB", "500GB", "2.4 Ghz"));
        System.out.println(pc);

        Computer server = ComputerFactory.getFactory(new ServerFactory("16 GB", "1 TB", "2.8 Ghz"));
        System.out.println(server);
    }
}
