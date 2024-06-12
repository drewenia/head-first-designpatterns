package CompoundPatterns.MVC;

/* View'in controller üzerinde çağırabileceği tüm methodlar burada verilmiştir.*/
public interface ControllerInterface {

    /* Modelin interface'ini gördükten sonra bunlar tanıdık gelecektir. Ritim üretimini durdurup başlatabilir ve BPM'yi
    değiştirebilirsiniz. Bu Interface BeatModel Interface'inden “daha zengindir” çünkü BPM'leri artırma ve azaltma ile
    ayarlayabilirsiniz.*/
    void start();
    void stop();
    void increaseBPM();
    void decreaseBPM();
    void setBPM(int bpm);
}
