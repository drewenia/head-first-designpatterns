package CompoundPatterns;

public class MallardDuck implements Quackable{

    /* Her Quackable'ın bir Observable instance variable'i vardır */
    Observable observable;

    /* constructor'da, bir Observable oluşturuyoruz ve ona MallardDuck nesnesine bir referans aktarıyoruz*/
    public MallardDuck(){
        observable = new Observable(this);
    }

    /* Quack çalıştığında, observer'ların bunu bilmesine izin vermeliyiz */
    @Override
    public void quack() {
        System.out.println("Quack");
        notifyObserver();
    }

    /* İşte iki QuackObservable methodumuz. Sadece helper'a delege ettiğimize dikkat edin */
    @Override
    public void registerObserver(Observer observer) {
        observable.registerObserver(observer);
    }

    @Override
    public void notifyObserver() {
        observable.notifyObserver();
    }
}
