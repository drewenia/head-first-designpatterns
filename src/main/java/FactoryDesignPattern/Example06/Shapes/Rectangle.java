package FactoryDesignPattern.Example06.Shapes;

public class Rectangle implements Shape{
    @Override
    public void draw() {
        System.out.println("Inside Rectangle::draw() method");
    }
}
