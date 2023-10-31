package FactoryDesignPattern.Example09.creator;

import FactoryDesignPattern.Example09.product.Button;

/* Base factory sınıfı. "Factory" ifadesinin sınıf için yalnızca bir rol olduğunu unutmayın. Farklı product'ların
oluşturulmasını gerektiren bazı temel business logic'lere sahip olmalıdır*/
public abstract class Dialog {
    // Other Code

    public void renderWindow(){
        Button okButton = createButton();
        okButton.render();
    }

    /* Subclass'lar, belirli Button nesneleri oluşturmak için bu methodu override edecekler */
    protected abstract Button createButton();

}
