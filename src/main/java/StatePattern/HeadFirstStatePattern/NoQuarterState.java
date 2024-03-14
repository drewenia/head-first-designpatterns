package StatePattern.HeadFirstStatePattern;

public class NoQuarterState implements State{
    GumballMachine gumballMachine;

    /* Constructor aracılığıyla Gumball Machine'e bir referans aktarılır. Bunu bir instance variable'da saklayacağız */
    public NoQuarterState(GumballMachine gumballMachine) {
        this.gumballMachine = gumballMachine;
    }

    @Override
    public void insertQuarter() {
        /* Eğer birisi bir çeyrek eklerse, çeyreğin kabul edildiğine dair bir mesaj yazdırırız ve ardından makinenin
        State'ini HasQuarterState olarak değiştiririz.*/
        System.out.println("You inserted a quarter");
        gumballMachine.setState(gumballMachine.getHasQuarterState());
    }

    @Override
    public void ejectQuarter() {
        /* Bize hiç vermediğiniz parayı geri alamazsınız! */
        System.out.println("You haven't inserted a quarter");
    }

    @Override
    public void turnCrank() {
        /* Ve bize ödeme yapmazsanız sakız alamazsınız */
        System.out.println("You turned, but there's no quarter");
    }

    @Override
    public void dispense() {
        /* Ödeme yapmadan sakız dağıtamayız */
        System.out.println("You need to pay first");
    }
}
