package StatePattern.Example03;

public class HasCorrectPin implements ATMState{
    ATMMachine atmMachine;

    public HasCorrectPin(ATMMachine atmMachine) {
        this.atmMachine = atmMachine;
    }

    @Override
    public void insertCard() {
        System.out.println("You already entered a card");
    }

    @Override
    public void ejectCard() {
        System.out.println("Your card is ejected");
        atmMachine.setState(atmMachine.getNoCardState());
    }

    @Override
    public void insertPin(int pinNumber) {
        System.out.println("You already entered a PIN");
    }

    @Override
    public void requestCash(int cashToWithdraw) {
        if (cashToWithdraw > atmMachine.cashInMachine){
            System.out.println("You don't have much cash available");
            System.out.println("Your card is ejected");
            atmMachine.setState(atmMachine.getNoCardState());
        } else {
            System.out.println(cashToWithdraw + " is provided by the machine");
            atmMachine.setState(atmMachine.getNoCardState());
            if (atmMachine.cashInMachine <= 0){
                atmMachine.setState(atmMachine.getOutOfMoneyState());
            }
        }
    }
}
