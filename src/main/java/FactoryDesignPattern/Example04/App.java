package FactoryDesignPattern.Example04;

import FactoryDesignPattern.Example04.Creator.AsusManufacturer;
import FactoryDesignPattern.Example04.Creator.Company;
import FactoryDesignPattern.Example04.Creator.MSIManufacturer;
import FactoryDesignPattern.Example04.Product.Gpu;
import FactoryDesignPattern.Example04.Product.Monitor;

public class App {
    public static void main(String[] args) {
        Company msi = new MSIManufacturer();
        Gpu msiGpu = msi.assemblyGpu();
        Monitor msiMonitor = msi.assemblyMonitor();

        Company asus = new AsusManufacturer();
        Gpu asusGpu = asus.assemblyGpu();
        Monitor asusMonitor = asus.assemblyMonitor();
    }
}
