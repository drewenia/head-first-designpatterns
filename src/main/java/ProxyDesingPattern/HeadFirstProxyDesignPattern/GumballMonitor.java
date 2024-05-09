package ProxyDesingPattern.HeadFirstProxyDesignPattern;

public class GumballMonitor {
    GumballMachineRemote gumballMachineRemote;

    public GumballMonitor(GumballMachineRemote gumballMachineRemote) {
        this.gumballMachineRemote = gumballMachineRemote;
    }

    /* Rapor methodumuz sadece location, count ve makinenin state'ini içeren bir rapor yazdırır.*/
    public void report() {
        try {
            System.out.println("Gumball machine : " + gumballMachineRemote.getLocation());
            System.out.println("Current Inventory : " + gumballMachineRemote.getCount());
            System.out.println("Current State : " + gumballMachineRemote.getState());
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}
