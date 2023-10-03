package CommandPattern.Example04.invoker;

import CommandPattern.Example04.command.Order;

import java.util.ArrayList;
import java.util.List;

public class Broker {
    private final List<Order> orderList = new ArrayList<>();

    public void takeOrder(Order order){
        orderList.add(order);
    }

    public void placeOrders(){
        orderList.forEach(Order::execute);
        orderList.clear();
    }
}
