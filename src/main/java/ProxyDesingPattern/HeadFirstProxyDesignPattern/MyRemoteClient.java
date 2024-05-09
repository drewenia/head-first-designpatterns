package ProxyDesingPattern.HeadFirstProxyDesignPattern;

import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class MyRemoteClient {
    public static void main(String[] args) {
        try{
            Registry registry = LocateRegistry.getRegistry();
            MyRemote server = (MyRemote) registry.lookup("RemoteHello");
            String responseMessage = server.sayHello();
            System.out.println(responseMessage);
        } catch (Exception exception){
            exception.printStackTrace();
        }
    }
}
