package FactoryDesignPattern.Example10.concreteFactory;

import FactoryDesignPattern.Example10.abstractFactory.GUIFactory;
import FactoryDesignPattern.Example10.concreteProduct.MacOSButton;
import FactoryDesignPattern.Example10.concreteProduct.MacOSCheckBox;
import FactoryDesignPattern.Example10.product.Button;
import FactoryDesignPattern.Example10.product.CheckBox;

/* Her concrete factory basic factory'i extends eder ve tek bir çeşit Product üretmekten sorumludur.*/
public class MacOSFactory implements GUIFactory {
    @Override
    public Button createButton() {
        return new MacOSButton();
    }

    @Override
    public CheckBox createCheckBox() {
        return new MacOSCheckBox();
    }
}
