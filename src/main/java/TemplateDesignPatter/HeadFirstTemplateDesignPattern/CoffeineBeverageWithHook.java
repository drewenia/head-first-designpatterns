package TemplateDesignPatter.HeadFirstTemplateDesignPattern;

public abstract class CoffeineBeverageWithHook {
    final void prepareReceipe(){
        boilWater();
        brew();
        pourInCup();

        /* Başarısını concrete bir metot olan customerWantsCondiments() methoduna dayandıran küçük bir koşullu ifade
        ekledik. Müşteri condiments isterse, ancak o zaman addCondiments() methodunu çağırıyoruz.*/
        if (customerWantsCondiments()){
            addCondiments();
        }
    }

    void boilWater(){
        System.out.println("Boiling Water");
    }

    abstract void brew();

    void pourInCup(){
        System.out.println("Pouring into cup");
    }

    abstract void addCondiments();

    /* Burada (çoğunlukla) boş bir varsayılan implementasyona sahip bir method tanımladık. Bu method sadece true
    değerini döndürür ve başka hiçbir şey yapmaz. Bu bir hook'dur çünkü subclass bu methodu override edebilir ancak
    bunu yapmak zorunda değildir */
    boolean customerWantsCondiments(){
        return true;
    }
}
