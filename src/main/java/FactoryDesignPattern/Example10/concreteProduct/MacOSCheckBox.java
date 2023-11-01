package FactoryDesignPattern.Example10.concreteProduct;

import FactoryDesignPattern.Example10.product.CheckBox;

public class MacOSCheckBox implements CheckBox {
    @Override
    public void paint() {
        System.out.println("Created :: MacOSCheckBox");
    }
}
