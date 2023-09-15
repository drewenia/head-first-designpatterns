package StrategyDesignPattern.Example02;

import StrategyDesignPattern.Example02.Strategy.PaymentStrategy;

public class PaymentService {
    private int cost;
    private final boolean includeDelivery = true;
    private PaymentStrategy paymentStrategy;

    public void processOrder(int cost){
        this.cost = cost;
        paymentStrategy.collectPaymentDetails();
        if (paymentStrategy.validatePaymentDetails()){
            paymentStrategy.pay(getTotal());
        }
    }

    private int getTotal() {
        return includeDelivery ? cost + 10 : cost;
    }

    public void setPaymentStrategy(PaymentStrategy paymentStrategy) {
        this.paymentStrategy = paymentStrategy;
    }
}
