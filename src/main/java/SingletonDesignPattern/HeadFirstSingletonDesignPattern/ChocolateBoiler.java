package SingletonDesignPattern.HeadFirstSingletonDesignPattern;

public class ChocolateBoiler {
    private boolean empty;
    private boolean boiled;

    public ChocolateBoiler() {
        /* Bu kod, yanlızca kazan boş olduğunda başlatılır!*/
        this.empty = true;
        this.boiled = false;
    }

    public void fill() {
        if (isEmpty()) {
            /* Kazanı doldurmak için önce boş olmalıdır ve bir kez dolu olduğunda boş ve kaynatılmış bayraklarını
            ayarlarız.*/
            this.empty = false;
            this.boiled = false;
        }
    }

    public void drain() {
        if (!isEmpty() && isBoiled()) {
            /* Kazanı boşaltmak için, kazanın dolu (not empty) ve (isBoiled true) olması gerekir. Bir kez
            boşaltıldığında, emply flag'ini yeniden true olarak ayarlarız.*/
            empty = true;
        }
    }

    public void boil(){
        if (!isEmpty() && !isBoiled()){
            /* Karışımı kaynatmak için, kazanın dolu olması ve daha önce kaynatılmamış olması gerekir. Bir kez
            kaynadığında, boiled flag'ini true olarak ayarlarız.*/
            boiled = true;
        }
    }

    public boolean isEmpty() {
        return empty;
    }

    public boolean isBoiled() {
        return boiled;
    }
}
