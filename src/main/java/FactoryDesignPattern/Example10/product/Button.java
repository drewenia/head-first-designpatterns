package FactoryDesignPattern.Example10.product;

/* Abstract Factory, ayrı sınıf hiyerarşileri (Button/Checkbox) halinde yapılandırılmış birkaç Product ailesine sahip
olduğunuzu varsayar. Aynı ailedeki tüm Product'lar ortak interface'e sahiptir. Bu Button ailesi için ortak
interface'dir*/
public interface Button {
    void paint();
}
