package StrategyDesignPattern.Example02.Strategy;

public class PaymentByPaypal implements PaymentStrategy{
    private String email;
    private String password;
    @Override
    public void collectPaymentDetails() {
        this.email = "...";
        this.password = "...";
    }

    @Override
    public boolean validatePaymentDetails() {
        return true;
    }

    @Override
    public void pay(int amount) {
        System.out.println("Paying " + amount + " using Paypal");
    }
}
