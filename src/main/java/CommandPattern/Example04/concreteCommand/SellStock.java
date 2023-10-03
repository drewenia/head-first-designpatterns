package CommandPattern.Example04.concreteCommand;

import CommandPattern.Example04.command.Order;
import CommandPattern.Example04.receiver.Stock;

public class SellStock implements Order {

    Stock stock;

    public SellStock(Stock stock) {
        this.stock = stock;
    }

    @Override
    public void execute() {
        stock.sell();
    }
}
