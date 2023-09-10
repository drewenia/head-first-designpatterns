package FactoryDesignPattern.Example04.Creator;

import FactoryDesignPattern.Example04.Product.Gpu;
import FactoryDesignPattern.Example04.Product.Monitor;
import FactoryDesignPattern.Example04.Product.MsiGpu;
import FactoryDesignPattern.Example04.Product.MsiMonitor;

public class MSIManufacturer extends Company{
    @Override
    public Gpu createGpu() {
        return new MsiGpu();
    }

    @Override
    public Monitor createMonitor() {
        return new MsiMonitor();
    }
}
