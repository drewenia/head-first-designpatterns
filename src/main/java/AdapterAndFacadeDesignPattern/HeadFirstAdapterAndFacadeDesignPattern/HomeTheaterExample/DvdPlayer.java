package AdapterAndFacadeDesignPattern.HeadFirstAdapterAndFacadeDesignPattern.HomeTheaterExample;

public class DvdPlayer {
    private String movie;

    public void on() {
        System.out.println("Dvd player on");
    }

    public void play(String movie){
        this.movie = movie;
    }

    public void stop() {
        System.out.println("Dvd player off");
    }

    public void eject() {
        System.out.println("Dvd ejected");
    }
}
