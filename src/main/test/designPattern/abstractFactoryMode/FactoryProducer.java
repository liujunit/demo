package designPattern.abstractFactoryMode;

public class FactoryProducer {

    public static AbstractFactory getFactory(String factoryName) {
        if (factoryName.equals("Shape")) {
            return new ShapeFactory();
        } else if (factoryName.equals("Color")) {
            return new ColorFactory();
        }
        return null;
    }

}
