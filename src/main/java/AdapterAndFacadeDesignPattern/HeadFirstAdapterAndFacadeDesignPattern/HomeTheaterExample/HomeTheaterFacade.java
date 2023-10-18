package AdapterAndFacadeDesignPattern.HeadFirstAdapterAndFacadeDesignPattern.HomeTheaterExample;

public class HomeTheaterFacade {
    /* İşte composition; bunlar kullanacağımız subsystem component'lerin tamamıdır.*/
    Ampilifier ampilifier;
    Tuner tuner;
    DvdPlayer dvdPlayer;
    CdPlayer cd;
    Projector projector;
    TheaterLights lights;
    Screen screen;
    PopcornPopper popper;

    /* Facade, constructor'ında subsystem component'lerinin her birine bir referans alır. Ardından, facade her birini
    karşılık gelen instance variable'a atar.*/
    public HomeTheaterFacade(Ampilifier ampilifier,
                             Tuner tuner,
                             DvdPlayer dvdPlayer,
                             CdPlayer cd,
                             Projector projector,
                             TheaterLights lights,
                             Screen screen,
                             PopcornPopper popper)
    {
        this.ampilifier = ampilifier;
        this.tuner = tuner;
        this.dvdPlayer = dvdPlayer;
        this.cd = cd;
        this.projector = projector;
        this.lights = lights;
        this.screen = screen;
        this.popper = popper;
    }

    /* Şimdi subsystem'in component'lerini birleştirip birleşik bir interface'e getirme zamanı geldi.
    "watchMovie()" ve "endMovie()" methodlarını uygulayalım.*/
    public void watchMovie(String movie){
        /* "watchMovie()" methodu, daha önce manuel olarak yapmak zorunda kaldığımız işlem sırasını takip eder,
        ancak tüm işi yapacak kullanışlı bir methoda sarar. Her görev için subsystem'da ki ilgili componente
        sorumluluğu devrettiğimize dikkat edin.*/

        System.out.println("Get ready to watch a movie");

        popper.on();
        popper.pop();

        lights.dim(10);

        screen.down();

        projector.on();
        projector.wideScreenMode();

        ampilifier.on();
        ampilifier.setDvd(dvdPlayer);
        ampilifier.setSurroundSound();
        ampilifier.setVolume(5);

        dvdPlayer.on();
        dvdPlayer.play(movie);
    }

    public void endMovie(){
        /* "endMovie()" methodu ise her şeyi kapatmakla ilgilenir. Yine, her görev subsystem'da ki uygun componente
        devredilir.*/

        System.out.println("shutting movie theater down");

        popper.off();

        lights.on();

        screen.up();

        projector.off();

        ampilifier.off();

        dvdPlayer.stop();
        dvdPlayer.eject();
        dvdPlayer.stop();
    }
}
