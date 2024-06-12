package CompoundPatterns.MVC;

import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.Line;
import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class BeatModel implements BeatModelInterface, Runnable {

    /* Bu ArrayList'ler iki tür observer'i (Beat ve BPM observer'ları) tutar */
    List<BeatObserver> beatObservers = new ArrayList<>();
    List<BPMObserver> bpmObservers = new ArrayList<>();

    /* bpm instance variable'i beat'lerin (vuruşların) frekansını tutar - varsayılan olarak 90 BPM */
    int bpm = 90;
    boolean stop = false;

    Thread thread;
    Clip clip;

    @Override
    public void run() {
        while (!stop) {
            playBeat();
            notifyBeatObservers();
            try {
                Thread.sleep(60000 / getBPM());
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public void initialize() {
        try {
            File resource = new File("/Users/cihangirkuce/Documents/GitHub/java-examples/head-frist-design-pattern/src/main/java/CompoundPatterns/MVC/clap.wav");
            clip = (Clip) AudioSystem.getLine(new Line.Info(Clip.class));
            clip.open(AudioSystem.getAudioInputStream(resource));
        } catch (Exception e) {
            System.out.println("Error: Can't load clip");
            System.out.println(e);
        }
    }

    @Override
    public void on() {
        bpm = 90;
        thread = new Thread(this);
        stop = false;
        thread.start();
    }

    @Override
    public void off() {
        stopBeat();
        stop = true;
    }

    @Override
    public void setBPM(int bpm) {
        this.bpm = bpm;
        /* BPM değiştiğinde tüm observer'lar bilgilendirilecek */
        notifyBPMObservers();
    }

    @Override
    public int getBPM() {
        return bpm;
    }

    @Override
    public void registerObserver(BeatObserver beatObserver) {
        beatObservers.add(beatObserver);
    }

    @Override
    public void removeObserver(BeatObserver beatObserver) {
        int i = beatObservers.indexOf(beatObserver);
        if (i >= 0) {
            beatObservers.remove(i);
        }
    }

    @Override
    public void registerObserver(BPMObserver bpmObserver) {
        bpmObservers.add(bpmObserver);
    }

    @Override
    public void removeObserver(BPMObserver bpmObserver) {
        int i = bpmObservers.indexOf(bpmObserver);
        if (i >= 0) {
            bpmObservers.remove(i);
        }
    }

    private void notifyBeatObservers() {
        beatObservers.forEach(BeatObserver::updateBeat);
    }

    private void notifyBPMObservers() {
        bpmObservers.forEach(BPMObserver::updateBPM);
    }

    private void stopBeat() {
        clip.setFramePosition(0);
        clip.stop();
    }

    private void playBeat() {
        clip.setFramePosition(0);
        clip.start();
    }
}
