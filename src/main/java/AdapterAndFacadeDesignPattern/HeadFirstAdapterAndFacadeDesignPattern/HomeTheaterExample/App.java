package AdapterAndFacadeDesignPattern.HeadFirstAdapterAndFacadeDesignPattern.HomeTheaterExample;

public class App {
    public static void main(String[] args) {
        PopcornPopper popper = new PopcornPopper();
        TheaterLights lights = new TheaterLights();
        Screen screen = new Screen();
        DvdPlayer dvd = new DvdPlayer();
        Projector projector = new Projector();
        Ampilifier amp = new Ampilifier();
        Tuner tuner = new Tuner();
        CdPlayer cd = new CdPlayer();

        HomeTheaterFacade facade = new HomeTheaterFacade(
          amp,tuner,dvd,cd,projector,lights,screen,popper
        );

        facade.watchMovie("Raiders of the Lost Ark");
        facade.endMovie();
    }
}
