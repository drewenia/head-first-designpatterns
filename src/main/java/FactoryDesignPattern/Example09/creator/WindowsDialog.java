package FactoryDesignPattern.Example09.creator;

import FactoryDesignPattern.Example09.product.Button;
import FactoryDesignPattern.Example09.product.WindowsButton;

public class WindowsDialog extends Dialog{
    @Override
    protected Button createButton() {
        return new WindowsButton();
    }
}
