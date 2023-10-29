package AdapterAndFacadeDesignPattern.Example08;

public class Circle implements Shape{
    @Override
    public void draw() {
        System.out.println("Circle::draw()");
    }
}
