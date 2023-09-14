package FactoryDesignPattern.Example06.Shapes;

public class RoundedSquare implements Shape{
    @Override
    public void draw() {
        System.out.println("Inside RoundedSquare::draw() method");
    }
}
