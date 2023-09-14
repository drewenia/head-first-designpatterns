package FactoryDesignPattern.Example06;

import FactoryDesignPattern.Example06.Factory.AbstractFactory;
import FactoryDesignPattern.Example06.Factory.FactoryProducer;
import FactoryDesignPattern.Example06.Shapes.Shape;

public class App {
    public static void main(String[] args) {
        AbstractFactory shapeFactory = FactoryProducer.getFactory(false);

        Shape rectangle = shapeFactory.getShape("RECTANGLE");
        rectangle.draw();

        Shape square = shapeFactory.getShape("SQUARE");
        square.draw();

        AbstractFactory roundedShapeFactory = FactoryProducer.getFactory(true);

        Shape roundedRectangle = roundedShapeFactory.getShape("RECTANGLE");
        roundedRectangle.draw();

        Shape roundedSquare = roundedShapeFactory.getShape("SQUARE");
        roundedSquare.draw();
    }
}
