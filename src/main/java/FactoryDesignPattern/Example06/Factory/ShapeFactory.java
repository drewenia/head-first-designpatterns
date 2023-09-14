package FactoryDesignPattern.Example06.Factory;

import FactoryDesignPattern.Example06.Shapes.Rectangle;
import FactoryDesignPattern.Example06.Shapes.Shape;
import FactoryDesignPattern.Example06.Shapes.Square;

public class ShapeFactory extends AbstractFactory {
    @Override
    public Shape getShape(String shapeType) {
        if (shapeType.equalsIgnoreCase("RECTANGLE")) {
            return new Rectangle();
        } else if (shapeType.equalsIgnoreCase("SQUARE")) {
            return new Square();
        }
        return null;
    }
}
