package CommandPattern.Example04.concreteCommand;

import CommandPattern.Example04.command.Order;
import CommandPattern.Example04.receiver.Stock;

public class BuyStock implements Order {

    Stock stock;

    public BuyStock(Stock stock) {
        this.stock = stock;
    }

    @Override
    public void execute() {
        stock.buy();
    }
}
