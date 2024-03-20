package StatePattern.Example03;

public class NoCard implements ATMState{
    ATMMachine atmMachine;

    public NoCard(ATMMachine atmMachine) {
        this.atmMachine = atmMachine;
    }

    @Override
    public void insertCard() {
        System.out.println("Please enter your pin");
        atmMachine.setState(atmMachine.getHasCardState());
    }

    @Override
    public void ejectCard() {
        System.out.println("You didn't enter a card");
    }

    @Override
    public void insertPin(int pinNumber) {
        System.out.println("You have not entered your card");
    }

    @Override
    public void requestCash(int cashToWithdraw) {
        System.out.println("You have not entered your card");
    }
}
