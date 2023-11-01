package FactoryDesignPattern.Example10.concreteProduct;

import FactoryDesignPattern.Example10.product.Button;

public class MacOSButton implements Button {
    @Override
    public void paint() {
        System.out.println("Created :: MacOSButton");
    }
}
