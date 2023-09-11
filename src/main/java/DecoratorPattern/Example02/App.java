package DecoratorPattern.Example02;

public class App {
    public static void main(String[] args) {
        INotifier notifier = new WhatsAppDecorator(new FacebookDecorator(new Notifier("test")));
        notifier.send("test");
    }
}
