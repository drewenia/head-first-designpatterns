package DecoratorPattern.Example02;

public class WhatsAppDecorator extends BaseNotifierDecorator{
    public WhatsAppDecorator(INotifier wrapped) {
        super(wrapped);
    }

    @Override
    public void send(String msg) {
        super.send(msg);
        System.out.println("Sending " + msg + " on Whatsapp");
    }
}
