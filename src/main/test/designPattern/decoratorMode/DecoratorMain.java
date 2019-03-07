package designPattern.decoratorMode;

/**
 * 装饰者模式
 */
public class DecoratorMain {

    public static void main(String[] args) {
        Shape circle = new Circle();
        circle.draw();
        Shape redCircle = new RedShapeDecorator(new Circle()) ;
        redCircle.draw();
        Shape redRectangle = new RedShapeDecorator(new Rectangle());
        redRectangle.draw();
    }

}
