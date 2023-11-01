package FactoryDesignPattern.Example10.concreteFactory;

import FactoryDesignPattern.Example10.abstractFactory.GUIFactory;
import FactoryDesignPattern.Example10.concreteProduct.WindowsButton;
import FactoryDesignPattern.Example10.concreteProduct.WindowsCheckBox;
import FactoryDesignPattern.Example10.product.Button;
import FactoryDesignPattern.Example10.product.CheckBox;

public class WindowsFactory implements GUIFactory {
    @Override
    public Button createButton() {
        return new WindowsButton();
    }

    @Override
    public CheckBox createCheckBox() {
        return new WindowsCheckBox();
    }
}
