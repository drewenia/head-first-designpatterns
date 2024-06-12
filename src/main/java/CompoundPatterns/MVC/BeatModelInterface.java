package CompoundPatterns.MVC;

public interface BeatModelInterface {

    /* initialize(), on(), off(), setBPM() bunlar, controller'in user etkileşimine dayalı olarak modeli yönlendirmek
    için kullanacağı methodlardır */

    /* Bu, BeatModel instantiate edildikten sonra çağrılır.*/
    void initialize();

    /* Bu method beat generator (ritim oluşturucuyu) açar */
    void on();

    /* Bu method beat generator (ritim oluşturucuyu) kapatır */
    void off();

    /* Bu method dakika başına vuruş sayısını ayarlar. Çağrıldıktan sonra, vuruş frekansı hemen değişir */
    void setBPM(int bpm);


    /* getBPM(), registerObserver(), removeObserver() Bu methodlar, View'in ve Controller'in state almasına ve observer
    olmasına olanak tanır.*/

    /* getBPM() methodu geçerli BPM'leri veya jeneratör kapalıysa 0 değerini döndürür */
    int getBPM();

    /* bu methodlar nesnelerin state değişiklikleri için observer olarak register ve unregister olmalarını sağlar. Bunu
    iki tür Observer'a ayırdık: her vuruşta bilgilendirilmek isteyen observer'lar ve sadece dakika başına vuruş
    değişikliği ile bilgilendirilmek isteyen Observer'lar.*/
    void registerObserver(BeatObserver beatObserver);
    void removeObserver(BeatObserver beatObserver);
    void registerObserver(BPMObserver bpmObserver);
    void removeObserver(BPMObserver bpmObserver);
}
