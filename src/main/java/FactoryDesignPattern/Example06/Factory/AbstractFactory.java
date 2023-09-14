package FactoryDesignPattern.Example06.Factory;

import FactoryDesignPattern.Example06.Shapes.Shape;

public abstract class AbstractFactory {
    public abstract Shape getShape(String shapeType);
}
