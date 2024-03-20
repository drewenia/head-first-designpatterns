package StatePattern.Example03;

public class ATMMachine {
    ATMState hasCard;
    ATMState noCard;
    ATMState hasCorrectPin;
    ATMState outOfMoney;
    ATMState state;

    int cashInMachine = 2000;
    boolean correctPinEntered = false;

    public ATMMachine() {
        this.hasCard = new HasCard(this);
        this.noCard = new NoCard(this);
        this.hasCorrectPin = new HasCorrectPin(this);
        this.outOfMoney = new OutOfMoney(this);

        state = noCard;

        if (cashInMachine < 0) {
            state = outOfMoney;
        }
    }

    public void setState(ATMState state) {
        this.state = state;
    }

    public void setCashInMachine(int cash) {
        cashInMachine = cash;
    }

    public void insertCard(){
        state.insertCard();
    }

    public void ejectCard(){
        state.ejectCard();
    }

    public void insertPin(int pin){
        state.insertPin(pin);
    }

    public void requestCash(int cashToWithdraw){
        state.requestCash(cashToWithdraw);
    }

    public ATMState getState(){
        return this.state;
    }

    public ATMState getHasCardState(){
        return this.hasCard;
    }

    public ATMState getNoCardState(){
        return this.noCard;
    }

    public ATMState getHasCorrectPinState(){
        return this.hasCorrectPin;
    }

    public ATMState getOutOfMoneyState(){
        return this.outOfMoney;
    }
}
