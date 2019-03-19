package designPattern.abstractFactoryMode;

public class ShapeFactory extends AbstractFactory {
    @Override
    public Shape getShapeFactory(String shape) {
        if (shape.equals("Rectangle")) {
            return new Rectangle();
        } else if (shape.equals("Square")) {
            return new Square();
        } else if (shape.equals("Circle")) {
            return new Circle();
        }
        return null;
    }

    @Override
    public Color getColorFactory(String color) {
        return null;
    }
}
