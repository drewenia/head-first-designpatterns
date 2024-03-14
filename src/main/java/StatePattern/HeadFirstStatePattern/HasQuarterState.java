package StatePattern.HeadFirstStatePattern;

import java.util.Random;

public class HasQuarterState implements State{
    /* Önce %10 kazanma şansı oluşturmak için rastgele bir sayı üreteci ekliyoruz...*/
    Random randomWinner = new Random(System.currentTimeMillis());
    GumballMachine gumballMachine;

    /* State oluşturulduğunda, ona bir GumballMachine referansı geçiriyoruz. Bu, makineyi farklı bir State'e geçirmek
    için kullanılır.*/
    public HasQuarterState(GumballMachine gumballMachine) {
        this.gumballMachine = gumballMachine;
    }

    /* Bu state için uygunsuz bir Action */
    @Override
    public void insertQuarter() {
        System.out.println("You can't insert another quarter");
    }

    /* Client'in çeyreğini iade et ve NoQuarterState State'ine geri geç */
    @Override
    public void ejectQuarter() {
        System.out.println("Quarter returned");
        gumballMachine.setState(gumballMachine.getNoQuarterState());
    }

    @Override
    public void turnCrank() {
        /* Kolu çevirdiğimizde, setState() methodunu çağırarak makineyi SoldState State'ine geçiririz ve ona SoldState
        nesnesini geçiririz. SoldState nesnesi, getSoldState() getter methodu aracılığıyla alınır (her State için bir
        tane bu tür bir getter methodu bulunmaktadır).*/
        System.out.println("You turned");
        int winner = randomWinner.nextInt(10);

        /* Eğer kazanmışlarsa ve iki tane alabilecekleri kadar sakız kalmışsa, WinnerState'e gideriz; aksi takdirde,
        SoldState'e gideriz (her zaman yaptığımız gibi).*/
        if ((winner==0) & (gumballMachine.getCount()>1)){
            gumballMachine.setState(gumballMachine.getWinnerState());
        } else {
            gumballMachine.setState(gumballMachine.getSoldState());
        }
        gumballMachine.setState(gumballMachine.getSoldState());
    }

    /* Bu state için başka uygunsuz bir action */
    @Override
    public void dispense() {
        System.out.println("No gumball dispensed");
    }
}
