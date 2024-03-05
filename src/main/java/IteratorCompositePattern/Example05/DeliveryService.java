package IteratorCompositePattern.Example05;

public class DeliveryService {
    private Box box;

    public void setupOrder(Box... boxes){
        this.box = new CompositeBox(boxes);
    }

    public double calculateOrderPrice(){
        return box.calculatePrice();
    }
}
