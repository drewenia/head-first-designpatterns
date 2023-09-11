package DecoratorPattern.Example02;

public class Notifier implements INotifier{
    private final String userName;

    public Notifier(String userName) {
        this.userName = userName;
    }

    @Override
    public void send(String msg){
        System.out.println("Sending " + msg + "to " + userName);
    }

    @Override
    public String getUserName() {
        return userName;
    }
}
