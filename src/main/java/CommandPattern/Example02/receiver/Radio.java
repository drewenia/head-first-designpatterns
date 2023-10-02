package CommandPattern.Example02.receiver;

public class Radio implements ElectronicDevice{
    @Override
    public void on() {
        System.out.println("Radio on");
    }

    @Override
    public void off() {
        System.out.println("Radio off");
    }

    @Override
    public void volumeUp() {
        System.out.println("Radio volume up");
    }

    @Override
    public void volumeDown() {
        System.out.println("Radio volume down");
    }
}
