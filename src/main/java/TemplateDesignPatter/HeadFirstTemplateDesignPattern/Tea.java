package TemplateDesignPatter.HeadFirstTemplateDesignPattern;

/* Tasarımımızda olduğu gibi, Tea ve Coffee artık CaffeinBeverage'i extend ediyor .*/
public class Tea extends CaffeineBeverage{

    /* Tea öğesinin, CaffeineBeverage öğesinin iki abstract methodu olan brew() ve addCondiments() öğelerini tanımlaması
    gerekir.*/
    @Override
    protected void brew() {
        System.out.println("Steeping the tea");
    }

    @Override
    protected void addCondiments() {
        System.out.println("Adding lemon");
    }
}
