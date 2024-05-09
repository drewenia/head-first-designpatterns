package ProxyDesingPattern.HeadFirstProxyDesignPattern;

import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;

/* Remote implementasyonu oluşturduktan sonra, remote nesneyi bir RMI registry'sine bind etmeniz gerekir.*/
public class MyRemoteImpl implements MyRemote {
    @Override
    public String sayHello() {
        return "Server say Hello";
    }

    public MyRemoteImpl() {
    }

    public static void main(String[] args) {
        try {
            /* Creating Stub */
            MyRemote server = new MyRemoteImpl();
            /* Stub implemantation'ini oluşturmak için statik UnicastRemoteObject.exportObject methodunu kullanırız
            Sıfır değerinin verilmesi, exportObject'in hangi portu kullandığını önemsemediğimizi gösterir ki bu tipik
            bir durumdur ve dinamik olarak seçilir.*/
            MyRemote stub = (MyRemote) UnicastRemoteObject.exportObject(server, 0);

            /* Bu, stub'ların server'lar tarafından bağlanabileceği ve client'lar tarafından keşfedilebileceği bir
            registry oluşturur. Ayrıca, registry'i server için local olarak oluşturduğumuzdan createRegistry methodunu
            kullandık. Varsayılan olarak, bir RMI registry 1099 numaralı port'da çalışır. Bunun yerine, createRegistry
            factory methodunda farklı bir port da belirtilebilir. Ancak stand-alone durumda, hostname ve port numarasını
            parametre olarak ileterek getRegistry'yi çağırırız.*/
            Registry registry = LocateRegistry.createRegistry(1099);

            /* Stub'in bind edilmesi */
            registry.rebind("RemoteHello",stub);

            System.err.println("Server ready...");

        } catch (Exception ex) {
            System.out.println("server exception..." + ex);
            ex.printStackTrace();
        }
    }
}
