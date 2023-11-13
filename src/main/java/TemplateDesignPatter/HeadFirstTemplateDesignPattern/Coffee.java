package TemplateDesignPatter.HeadFirstTemplateDesignPattern;

public class Coffee extends CaffeineBeverage{

    /* Coffee için de aynı şey geçerlidir, ancak Coffee, Tea Bags ve Lemon yerine coffee, sugar ve milk ile ilgilenir.*/
    @Override
    protected void brew() {
        System.out.println("Dripping Coffee through filter");
    }

    @Override
    protected void addCondiments() {
        System.out.println("Adding sugar and milk");
    }
}
