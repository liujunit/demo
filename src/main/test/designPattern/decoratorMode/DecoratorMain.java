package designPattern.decoratorMode;

/**
 * 装饰者模式
 * 为已有的功能 动态的添加更多的功能
 * 把类中的装饰功能从类中移除，简化原有类
 * 把核心职责和装饰的功能区分开来，去除相关类中的重复的逻辑， 比如有的红色，有的黄色 类中或许就得有两个方法
 */
public class DecoratorMain {

    public static void main(String[] args) {
        Shape circle = new Circle();
        circle.draw();
        Shape redCircle = new RedShapeDecorator(new Circle()) ;
        System.out.println("---------------------");
        redCircle.draw();
        Shape yellowCircle = new YellowShapeDecorator(redCircle);
        System.out.println("---------------------");
        yellowCircle.draw();
        Shape redRectangle = new RedShapeDecorator(new Rectangle());
        System.out.println("---------------------");
        redRectangle.draw();
    }

}
