package designPattern.abstractFactoryMode;

/**
 * 抽象工厂模式
 * 在简单工厂模式的基础上 围绕一个超级工厂生产其他工厂
 */
public class AbstractFactoryTest {

    public static void main(String[] args) {
        AbstractFactory shape = FactoryProducer.getFactory("Shape");
        Shape circle = shape.getShapeFactory("Circle");
        circle.draw();
    }

}
