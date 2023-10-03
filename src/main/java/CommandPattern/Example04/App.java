package CommandPattern.Example04;

import CommandPattern.Example04.concreteCommand.BuyStock;
import CommandPattern.Example04.concreteCommand.SellStock;
import CommandPattern.Example04.invoker.Broker;
import CommandPattern.Example04.receiver.Stock;

public class App {
    public static void main(String[] args) {
        Stock stock = new Stock();

        BuyStock buyStockOrder = new BuyStock(stock);
        SellStock sellStockOrder = new SellStock(stock);

        Broker broker = new Broker();
        broker.takeOrder(buyStockOrder);
        broker.takeOrder(sellStockOrder);

        broker.placeOrders();
    }
}
