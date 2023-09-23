package SingletonDesignPattern.Example02;

public class MultithreadSingleton {
    private static volatile MultithreadSingleton instance;

    private MultithreadSingleton(){}

    public static MultithreadSingleton getInstance(){
        if (instance == null){
            synchronized (MultithreadSingleton.class){
                if (instance == null){
                    return new MultithreadSingleton();
                }
            }
        }
        return instance;
    }
}
