package SingletonDesignPattern;

public class Singleton {
    private volatile static Singleton uniqueInstance;

    private Singleton(){}

    public static Singleton getInstance(){
        /* Bir instance'i kontrol edin ve eğer bir instance yoksa synchronized bir bloğa girin. Dikkat edin, sadece ilk
        kez geçişte synchronize ediyoruz! */
        if (uniqueInstance == null){
            synchronized (Singleton.class) {
                if (uniqueInstance == null){
                    /* Bir kez blok içine girdikten sonra tekrar kontrol edin ve hala null ise bir instance oluşturun.*/
                    uniqueInstance = new Singleton();
                }
            }
        }
        return uniqueInstance;
    }
}
