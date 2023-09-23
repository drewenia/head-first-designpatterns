package SingletonDesignPattern.Example01;

public class Singleton {
    private static volatile Singleton uniqueInstance;
    private String data;

    private Singleton(String data){
        this.data = data;
    }

    public static Singleton getInstance(String data){
        if (uniqueInstance == null){
            synchronized (Singleton.class){
                if (uniqueInstance == null){
                    uniqueInstance = new Singleton(data);
                }
            }
        }
        return uniqueInstance;
    }

}
