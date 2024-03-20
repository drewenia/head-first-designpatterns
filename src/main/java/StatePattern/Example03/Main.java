package StatePattern.Example03;

public class Main {
    public static void main(String[] args) {
        ATMMachine atmMachine = new ATMMachine();

        atmMachine.insertCard();
        atmMachine.ejectCard();

        atmMachine.insertCard();
        atmMachine.insertPin(1234);
        atmMachine.requestCash(1900);

        atmMachine.insertCard();
        atmMachine.insertPin(1234);
    }
}
