package DecoratorPattern.Example02;

public abstract class BaseNotifierDecorator implements INotifier{
    private final INotifier wrapped;

    BaseNotifierDecorator(INotifier wrapped) {
        this.wrapped = wrapped;
    }

    @Override
    public void send(String msg) {
        wrapped.send(msg);
    }

    @Override
    public String getUserName() {
        return wrapped.getUserName();
    }
}
