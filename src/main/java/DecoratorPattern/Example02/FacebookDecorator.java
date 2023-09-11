package DecoratorPattern.Example02;

public class FacebookDecorator extends BaseNotifierDecorator{
    public FacebookDecorator(INotifier wrapped) {
        super(wrapped);
    }

    @Override
    public void send(String msg) {
        super.send(msg);
        System.out.println("Sending " + msg + " on Facebook");
    }
}
