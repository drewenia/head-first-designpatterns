package ProxyDesingPattern.HeadFirstProxyDesignPattern;

public class SoldState implements State {
    GumballMachine gumballMachine;

    public SoldState(GumballMachine gumballMachine) {
        this.gumballMachine = gumballMachine;
    }

    @Override
    public void insertQuarter() {
        System.out.println("Please wait, we're already giving you a gumball");
    }

    @Override
    public void ejectQuarter() {
        System.out.println("Sorry, you already turned the crank");
    }

    @Override
    public void turnCrank() {
        System.out.println("Turning twice doesn't get your another gumball");
    }

    /* Ve işte asıl iş burada başlıyor...*/
    @Override
    public void dispense() {
        /* SoldState state'indeyiz, yani müşteri ödeme yaptı. Bu yüzden önce makineden bir sakız bırakmasını istememiz
        gerekiyor.*/
        gumballMachine.releaseBall();

        /* Ardından makineye sakız sayısının ne olduğunu sorarız ve ya NoQuarterState ya da SoldOutState State'ine
        geçeriz.*/
        if (gumballMachine.getCount() > 0){
            gumballMachine.setState(gumballMachine.getNoQuarterState());
        } else {
            System.out.println("Oops, out of gumball");
            gumballMachine.setState(gumballMachine.getSoldOutState());
        }
    }
}
