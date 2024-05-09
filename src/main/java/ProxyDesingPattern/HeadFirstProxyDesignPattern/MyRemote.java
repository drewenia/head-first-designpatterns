package ProxyDesingPattern.HeadFirstProxyDesignPattern;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface MyRemote extends Remote {
    String sayHello() throws RemoteException;
}
