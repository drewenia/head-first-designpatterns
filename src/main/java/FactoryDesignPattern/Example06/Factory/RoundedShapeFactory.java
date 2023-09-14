package FactoryDesignPattern.Example06.Factory;

import FactoryDesignPattern.Example06.Shapes.RoundedRectangle;
import FactoryDesignPattern.Example06.Shapes.RoundedSquare;
import FactoryDesignPattern.Example06.Shapes.Shape;

public class RoundedShapeFactory extends AbstractFactory{
    @Override
    public Shape getShape(String shapeType) {
        if (shapeType.equalsIgnoreCase("RECTANGLE")){
            return new RoundedRectangle();
        } else if (shapeType.equalsIgnoreCase("SQUARE")){
            return new RoundedSquare();
        }
        return null;
    }
}
