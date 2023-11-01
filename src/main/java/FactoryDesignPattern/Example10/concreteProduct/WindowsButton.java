package FactoryDesignPattern.Example10.concreteProduct;

import FactoryDesignPattern.Example10.product.Button;

public class WindowsButton implements Button {
    @Override
    public void paint() {
        System.out.println("Created :: Windows Button");
    }
}
