package CompoundPatterns.MVC;

public class DJTestDrive {
    public static void main(String[] args) {

        /* Ilk olarak model oluşturulur */
        BeatModelInterface model = new BeatModel();

        /* ...sonra bir Controller oluşturun ve Modeli ona aktarın. Unutmayın, Controller View'i oluşturur, bu yüzden
        bunu yapmak zorunda değiliz*/
        ControllerInterface controller = new BeatController(model);
    }
}
