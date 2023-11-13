package TemplateDesignPatter.HeadFirstTemplateDesignPattern;

public class BeverageTestDrive {
    public static void main(String[] args) {
        CoffeeWithHook coffeeHook = new CoffeeWithHook();

        System.out.println("Making coffee");
        coffeeHook.prepareReceipe();
    }
}
