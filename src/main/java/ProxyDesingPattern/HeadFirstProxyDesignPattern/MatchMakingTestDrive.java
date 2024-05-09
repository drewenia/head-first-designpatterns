package ProxyDesingPattern.HeadFirstProxyDesignPattern;

import java.lang.reflect.Proxy;
import java.util.HashMap;

public class MatchMakingTestDrive {

    HashMap<String, PersonBean> datingDB = new HashMap<>();

    public static void main(String[] args) {
        MatchMakingTestDrive test = new MatchMakingTestDrive();
        test.driveOwnerProxy();
        System.out.println("\n");
        test.driveNonOwnerProxy();
    }

    public MatchMakingTestDrive() {
        initializeDatabase();
    }

    public void driveOwnerProxy() {
        PersonBean joe = getPersonFromDB("Joe");
        PersonBean ownerProxy = getOwnerProxy(joe); //getOwnerProxy methodu yardımı ile PersonBean'i alıyoruz
        System.out.println(ownerProxy.getName());

        ownerProxy.setInterest("bowling"); // ownerProxy'e sahip olduğumuz için interest'i set edebiliyoruz
        System.out.println(ownerProxy.getInterest());

        ownerProxy.setName("Jow"); // ownerProxy'e sahip olduğumuz için name'i set edebiliyoruz
        System.out.println(ownerProxy.getName());

        /* OwnerInvocationHandler içerisinde setHotOrNotRating methoduna izin verilmediği için catch bloğu çalışacak */
        try {
            ownerProxy.setHotOrNotRating(10);
        } catch (Exception e) {
            System.out.println("Can't set rating from owner proxy");
        }
        System.out.println("Rating is " + ownerProxy.getHotOrNotRating());
    }

    public void driveNonOwnerProxy() {
        PersonBean jenny = getPersonFromDB("Jenny");
        PersonBean nonOwnerProxy = getNonOwnerProxy(jenny);
        System.out.println(nonOwnerProxy.getName());

        /* NonOwnerInvocationHandler kullanıldığı için interest'ler set edilemez, catch bloğu çalışacak */
        try {
            nonOwnerProxy.setInterest("coding");
        } catch (Exception e) {
            System.out.println("Can't set interests from non owner proxy");
        }

        /* NonOwnerInvocationHandler kullanıldığı için setHotOrNothing'e izin veriliyor */
        nonOwnerProxy.setHotOrNotRating(4);
        System.out.println("Rating set from non owner proxy");
        System.out.println(nonOwnerProxy.getHotOrNotRating());
    }

    PersonBean getOwnerProxy(PersonBean personBean) {
        return (PersonBean) Proxy.newProxyInstance(
                personBean.getClass().getClassLoader(),
                personBean.getClass().getInterfaces(),
                new OwnerInvocationHandler(personBean));
    }

    PersonBean getNonOwnerProxy(PersonBean personBean) {
        return (PersonBean) Proxy.newProxyInstance(
                personBean.getClass().getClassLoader(),
                personBean.getClass().getInterfaces(),
                new NonOwnerInvocationHandler(personBean)
        );
    }

    PersonBean getPersonFromDB(String name) {
        return datingDB.get(name);
    }

    private void initializeDatabase() {
        PersonBean joe = new PersonBeanImpl();
        joe.setName("Joe");
        joe.setInterest("cars, computers, music");
        joe.setHotOrNotRating(7);
        datingDB.put(joe.getName(), joe);

        PersonBean jenny = new PersonBeanImpl();
        jenny.setName("Jenny");
        jenny.setInterest("movies, music");
        jenny.setHotOrNotRating(6);
        datingDB.put(jenny.getName(), jenny);
    }
}
