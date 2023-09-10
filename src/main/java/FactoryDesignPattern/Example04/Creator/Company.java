package FactoryDesignPattern.Example04.Creator;

import FactoryDesignPattern.Example04.Product.Gpu;
import FactoryDesignPattern.Example04.Product.Monitor;

public abstract class Company {

    public Gpu assemblyGpu(){
        Gpu gpu = createGpu();
        gpu.assemble();
        return gpu;
    }

    public Monitor assemblyMonitor(){
        Monitor monitor = createMonitor();
        monitor.assemble();;
        return monitor;
    }

    public abstract Gpu createGpu();

    public abstract Monitor createMonitor();
}
