package CompoundPatterns;

import java.util.ArrayList;

/* Observable, QuackObservable'i implemente etmelidir çünkü bunlar kendisine delege edilecek aynı method çağrılarıdır */
public class Observable implements QuackObservable {

    ArrayList<Observer> observers = new ArrayList<>();
    QuackObservable duck;

    /* Constructor'da, observable behavior'unu yönetmek için bu nesneyi kullanan QuackObservable'ı geçiririz. Aşağıdaki
    notify() methoduna göz atın; bir notify gerçekleştiğinde Observable'ın bu nesneyi ilettiğini göreceksiniz,
    böylece observer hangi nesnenin quack yaptığını bilir.*/
    public Observable(QuackObservable duck) {
        this.duck = duck;
    }

    /* Observer'ları register ettiğimiz method */
    @Override
    public void registerObserver(Observer observer) {
        observers.add(observer);
    }

    /* Notification'lar için kullanılacak method */
    @Override
    public void notifyObserver() {
        observers.forEach(observer -> {
            observer.update(duck);
        });
    }
}
