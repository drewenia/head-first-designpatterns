package AdapterAndFacadeDesignPattern.Example08;

public class Rectangle implements Shape{
    @Override
    public void draw() {
        System.out.println("Rectangle::draw()");
    }
}
