package ObserverDesignPattern.Example03;

import ObserverDesignPattern.Example03.Publisher.Store;
import ObserverDesignPattern.Example03.Subscriber.EmailMsgListener;

public class App {
    public static void main(String[] args) {
        Store store = new Store();
        store.getNotificationService().subscribe(Event.NEW_ITEM,new EmailMsgListener("egedata@gmail.com"));
        store.getNotificationService().subscribe(Event.SALE,new EmailMsgListener("egedata@gmail.com"));

        store.newItemPromotion();
        store.salePromotion();
    }
}
