package StatePattern.Example02;

public class VendingMachineContext {
    private VendingMachineState state;

    public void setState(VendingMachineState state){
        this.state = state;
    }

    public void request(){
        this.state.handleRequest();
    }
}
