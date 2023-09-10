package FactoryDesignPattern.Example04.Creator;

import FactoryDesignPattern.Example04.Product.AsusGpu;
import FactoryDesignPattern.Example04.Product.AsusMonitor;
import FactoryDesignPattern.Example04.Product.Gpu;
import FactoryDesignPattern.Example04.Product.Monitor;

public class AsusManufacturer extends Company{
    @Override
    public Gpu createGpu() {
        return new AsusGpu();
    }

    @Override
    public Monitor createMonitor() {
        return new AsusMonitor();
    }
}
