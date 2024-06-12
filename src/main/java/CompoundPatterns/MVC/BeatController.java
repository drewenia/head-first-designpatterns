package CompoundPatterns.MVC;

public class BeatController implements ControllerInterface {

    /* Controller, MVC oreo kurabiyesinin ortasındaki kremalı şeydir, bu nedenle View'i ve Modeli tutan ve hepsini
    birbirine yapıştıran nesnedir.*/
    BeatModelInterface model;
    DJView view;

    public BeatController(BeatModelInterface model) {

        /* Controller, constructor'da Modeli geçirir ve ardından View'i oluşturur.*/
        this.model = model;
        view = new DJView(model, this);
        view.createView();
        view.createControls();
        view.disableStopMenuItem();
        model.initialize();
    }

    @Override
    public void start() {

        /* Kullanıcı arayüzü menüsünden Start'ı seçtiğinizde kontrol ünitesi Modeli açar ve ardından kullanıcı arayüzünü,
        Start menü öğesi devre dışı bırakılacak ve Stop menü öğesi etkinleştirilecek şekilde değiştirir.*/
        model.on();
        view.disableStartMenuItem();
        view.enableStopMenuItem();
    }

    @Override
    public void stop() {

        /* Aynı şekilde, menüden Stop öğesini seçtiğinizde, kontrol ünitesi Modeli kapatır ve kullanıcı arayüzünü, Stop
        menü öğesi devre dışı bırakılacak ve Start menü öğesi etkinleştirilecek şekilde değiştirir*/
        model.off();
        view.disableStopMenuItem();
        view.enableStartMenuItem();
    }

    @Override
    public void increaseBPM() {

        /* Artır düğmesine tıklanırsa Controller Modelden geçerli BPM'yi alır, bir ekler ve ardından yeni bir BPM
        set eder.*/
        int bpm = model.getBPM();
        model.setBPM(bpm + 1);
    }

    @Override
    public void decreaseBPM() {

        /* Burada da yukarıda ki ile aynı şey, sadece mevcut BPM'den bir çıkarıyoruz.*/
        int bpm = model.getBPM();
        model.setBPM(bpm - 1);
    }

    @Override
    public void setBPM(int bpm) {

        /* Son olarak, kullanıcı arayüzü keyfi bir BPM ayarlamak için kullanılırsa, Controller Modele BPM'sini
        ayarlaması talimatını verir.*/
        model.setBPM(bpm);
    }
}
