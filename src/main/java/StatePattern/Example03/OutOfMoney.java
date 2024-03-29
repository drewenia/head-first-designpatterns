package StatePattern.Example03;

public class OutOfMoney implements ATMState{
    ATMMachine atmMachine;

    public OutOfMoney(ATMMachine atmMachine) {
        this.atmMachine = atmMachine;
    }

    @Override
    public void insertCard() {
        System.out.println("We don't have any money");
        System.out.println("Your card is ejected");
    }

    @Override
    public void ejectCard() {
        System.out.println("We don't have any money");
        System.out.println("There is no card to eject");
    }

    @Override
    public void insertPin(int pinNumber) {
        System.out.println("We don't have any money");
    }

    @Override
    public void requestCash(int cashToWithdraw) {
        System.out.println("We don't have any money");
    }
}
