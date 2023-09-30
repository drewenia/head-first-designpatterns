package CommandPattern.HeadFirstCommandPattern;

public class Stereo {
    private final String name;

    public Stereo(String name) {
        this.name = name;
    }

    public void on(){
        System.out.println("Stereo on");
    }

    public void setCD(){
        System.out.println("CD 11");
    }

    public void setVolume(int volume){
        System.out.println("Volume setted " + volume);
    }

    public void off() {
        System.out.println("Stereo off");
    }
}
