package AdapterAndFacadeDesignPattern.HeadFirstAdapterAndFacadeDesignPattern.HomeTheaterExample;

public class TheaterLights {
    private int value;
    public void dim(int value){
        this.value = value;
    }

    public void on() {
        System.out.println("Lights turn on");
    }
}
