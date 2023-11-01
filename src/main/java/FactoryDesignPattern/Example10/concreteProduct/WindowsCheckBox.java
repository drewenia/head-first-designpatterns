package FactoryDesignPattern.Example10.concreteProduct;

import FactoryDesignPattern.Example10.product.CheckBox;

public class WindowsCheckBox implements CheckBox {
    @Override
    public void paint() {
        System.out.println("Created :: WindowsCheckBox");
    }
}
