package ProxyDesingPattern.HeadFirstProxyDesignPattern;

import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class GumballMonitorTestDrive {
    public static void main(String[] args) {
        try {
            Registry registry = LocateRegistry.getRegistry();
            GumballMachineRemote server = (GumballMachineRemote) registry.lookup("RemoteGumble");

            String location = server.getLocation();
            int count = server.getCount();
            State state = server.getState();
            System.out.println("Location : " + location);
            System.out.println("Count : " + count);
            System.out.println(state);

        } catch (Exception ex){
            ex.printStackTrace();
        }
    }
}
