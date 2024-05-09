package ProxyDesingPattern.HeadFirstProxyDesignPattern;

import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;

public class GumballMachineTestDrive {
    public static void main(String[] args) {
        GumballMachineRemote gumballMachineRemote = null;
        int count;

        if (args.length < 2) {
            System.err.println("Gumball machine <name> <inventory>");
            System.exit(1);
        }

        try {
            count = Integer.parseInt(args[1]);
            gumballMachineRemote = new GumballMachine(count, args[0]);
            gumballMachineRemote = (GumballMachineRemote) UnicastRemoteObject.exportObject(gumballMachineRemote, 0);

            Registry registry = LocateRegistry.createRegistry(1099);
            registry.rebind("RemoteGumble", gumballMachineRemote);
            System.err.println("Server ready...");
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}
