package CommandPattern.Example02.receiver;

public class Television implements ElectronicDevice{
    private int volume = 0;

    @Override
    public void on() {
        System.out.println("Television on");
    }

    @Override
    public void off() {
        System.out.println("Television off");
    }

    @Override
    public void volumeUp() {
        volume++;
        System.out.println("Tv Volume is at " + volume);
    }

    @Override
    public void volumeDown() {
        volume--;
        System.out.println("Tv Volume is at " + volume);
    }
}
