package TemplateDesignPatter.HeadFirstTemplateDesignPattern;

/*
    CaffeineBeverage, tıpkı sınıf tasarımında olduğu gibi abstract'dır.
*/
public abstract class CaffeineBeverage {

    /*
        Şimdi, hem Tea hem de Coffee yapmak için aynı prepareRecipe() methodu kullanılacaktır. prepareRecipe() final
        olarak bildirilmiştir çünkü subclass'larımızın bu methodu override etmesini ve tarifi değiştirmesini
        istemiyoruz! brew() ve addCondiments() için 3. ve 4. adımları genelleştirdik.
    */
    final void prepareReceipe(){
        boilWater();
        pourInCup();
        brew();
        addCondiments();
    }

    /* Coffee ve Tea bu methodları farklı şekillerde ele aldığından, abstract olarak bildirilmeleri gerekecektir.
    Bırakın bu konuda alt sınıflar endişelensin!*/
    protected abstract void brew();

    /* Coffee ve Tea bu methodları farklı şekillerde ele aldığından, abstract olarak bildirilmeleri gerekecektir.
    Bırakın bu konuda alt sınıflar endişelensin!*/
    protected abstract void addCondiments();

    /* Bunları CaffeineBeverage sınıfına taşıdığımızı hatırlayın (sınıf diyagramımızda). */
    private void boilWater() {
        System.out.println("Boiling water");
    }

    /* Bunları CaffeineBeverage sınıfına taşıdığımızı hatırlayın (sınıf diyagramımızda). */
    private void pourInCup() {
        System.out.println("Pouring into cup");
    }
}
