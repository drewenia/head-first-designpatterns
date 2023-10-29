package AdapterAndFacadeDesignPattern.Example08;

public class ShapeFacade {
    private final Shape circle;
    private final Shape rectangle;
    private final Shape square;

    public ShapeFacade() {
        circle = new Circle();
        rectangle = new Rectangle();
        square = new Square();
    }

    public void drawCircle(){
        circle.draw();
    }

    public void drawRectangle(){
        rectangle.draw();
    }

    public void drawSquare(){
        square.draw();
    }
}
