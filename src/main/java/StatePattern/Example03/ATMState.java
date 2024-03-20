package StatePattern.Example03;

public interface ATMState {
    void insertCard();
    void ejectCard();
    void insertPin(int pinNumber);
    void requestCash(int cashToWithdraw);
}
