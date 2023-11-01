package FactoryDesignPattern.Example10;

import FactoryDesignPattern.Example10.abstractFactory.GUIFactory;
import FactoryDesignPattern.Example10.product.Button;
import FactoryDesignPattern.Example10.product.CheckBox;

public class Application {
    private final Button button;
    private final CheckBox checkBox;

    public Application(GUIFactory factory) {
        button = factory.createButton();
        checkBox = factory.createCheckBox();
    }

    public void paint(){
        button.paint();
        checkBox.paint();
    }
}
