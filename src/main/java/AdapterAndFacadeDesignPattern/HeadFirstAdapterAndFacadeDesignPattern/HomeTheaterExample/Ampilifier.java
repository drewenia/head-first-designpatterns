package AdapterAndFacadeDesignPattern.HeadFirstAdapterAndFacadeDesignPattern.HomeTheaterExample;

public class Ampilifier {
    private DvdPlayer dvd;
    private int volume;

    private boolean surroundSound;

    public void on() {
        System.out.println("Amplifier On...");
    }

    public void setDvd(DvdPlayer dvd) {
        this.dvd = dvd;
    }

    public void setVolume(int volume) {
        this.volume = volume;
    }

    public void setSurroundSound() {
        this.surroundSound = true;
    }

    public void off() {
        System.out.println("Amplifier off");
    }
}
