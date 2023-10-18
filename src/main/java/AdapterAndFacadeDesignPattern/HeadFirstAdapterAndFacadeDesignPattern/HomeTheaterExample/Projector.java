package AdapterAndFacadeDesignPattern.HeadFirstAdapterAndFacadeDesignPattern.HomeTheaterExample;

public class Projector {
    private DvdPlayer input;

    public void on(){
        System.out.println("Projector open...");
    }

    public void setInput(DvdPlayer input) {
        this.input = input;
    }

    public void wideScreenMode(){
        System.out.println("Projector set to the wide screen mode");
    }

    public void off() {
        System.out.println("Projector close..");
    }
}
