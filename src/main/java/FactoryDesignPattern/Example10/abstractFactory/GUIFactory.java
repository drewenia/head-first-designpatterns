package FactoryDesignPattern.Example10.abstractFactory;

import FactoryDesignPattern.Example10.product.Button;
import FactoryDesignPattern.Example10.product.CheckBox;

/* Abstrat factory tüm (abstract) Product Type'larını bilir.*/
public interface GUIFactory {
    Button createButton();
    CheckBox createCheckBox();
}
