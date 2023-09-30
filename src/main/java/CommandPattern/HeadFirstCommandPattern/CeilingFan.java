package CommandPattern.HeadFirstCommandPattern;

public class CeilingFan {
    private final String name;
    private int speed;
    public static final int HIGH = 3;
    public static final int MEDIUM = 2;
    public static final int LOW = 1;
    public static final int OFF = 0;

    public CeilingFan(String name) {
        /* Dikkat edin ki CeilingFan sınıfı, CeilingFan'ın hızını temsil eden local bir state'i saklar*/
        this.name = name;
        this.speed = OFF;
    }

    /* Ceiling fan'ın hızını set eden methodlar */
    public void high(){
        this.speed = HIGH;
    }

    public void medium(){
        this.speed = MEDIUM;
    }

    public void low(){
        this.speed = LOW;
    }

    public void off(){
        this.speed = OFF;
    }

    /* CeilingFan'ın mevcut hızını getSpeed() kullanarak alabiliriz.*/
    public int getSpeed() {
        return speed;
    }
}
