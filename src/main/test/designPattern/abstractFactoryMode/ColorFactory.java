package designPattern.abstractFactoryMode;

public class ColorFactory extends AbstractFactory {
    @Override
    public Shape getShapeFactory(String shape) {
        return null;
    }

    @Override
    public Color getColorFactory(String color) {
        if (color.equals("Red")) {
            return new Red();
        }else if (color.equals("Green")) {
            return new Green();
        }else if (color.equals("Blue")) {
            return new Blue();
        }
        return null;
    }
}
