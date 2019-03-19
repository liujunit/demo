package designPattern.abstractFactoryMode;

public abstract class AbstractFactory {

    public abstract Shape getShapeFactory(String shape);

    public abstract Color getColorFactory(String color);

}
