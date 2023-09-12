package DecoratorPattern.Example04;

public class App {
    public static void main(String[] args) {
        Shape circle = new Circle();
        Shape redCircle = new RedShapeDecorator(new Circle());
        Shape redTriange = new RedShapeDecorator(new Triangle());

        System.out.println("Circle with normal border");
        circle.draw();

        System.out.println("\nCircle of red border");
        redCircle.draw();

        System.out.println("\nTriangle of red border");
        redTriange.draw();
    }
}
