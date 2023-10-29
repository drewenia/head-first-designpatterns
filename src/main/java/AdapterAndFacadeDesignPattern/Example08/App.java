package AdapterAndFacadeDesignPattern.Example08;

public class App {
    public static void main(String[] args) {
        ShapeFacade facade = new ShapeFacade();

        facade.drawCircle();
        facade.drawRectangle();
        facade.drawSquare();
    }
}
