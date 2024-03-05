package IteratorCompositePattern.Example05;

public class Main {
    public static void main(String[] args) {
        DeliveryService deliveryService = new DeliveryService();

        deliveryService.setupOrder(
                new CompositeBox(new VideoGame("1",100)),
                new CompositeBox(
                        new CompositeBox(
                                new Book("2",200),
                                new Book("3",400)
                        ),
                        new VideoGame("4",500),
                        new VideoGame("5",100)
                )
        );

        double price = deliveryService.calculateOrderPrice();
        System.out.println(price);
    }
}
