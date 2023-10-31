package FactoryDesignPattern.Example09.creator;

import FactoryDesignPattern.Example09.product.Button;
import FactoryDesignPattern.Example09.product.HtmlButton;

public class HtmlDialog extends Dialog{
    @Override
    protected Button createButton() {
        return new HtmlButton();
    }
}
