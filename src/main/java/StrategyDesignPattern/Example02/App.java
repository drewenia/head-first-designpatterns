package StrategyDesignPattern.Example02;

import StrategyDesignPattern.Example02.Strategy.PaymentByCreditCard;
import StrategyDesignPattern.Example02.Strategy.PaymentByPaypal;

public class App {
    public static void main(String[] args) {
        PaymentService service = new PaymentService();

        service.setPaymentStrategy(new PaymentByCreditCard());
        service.processOrder(100);

        service.setPaymentStrategy(new PaymentByPaypal());
        service.processOrder(200);
    }
}
