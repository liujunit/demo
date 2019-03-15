package designPattern.decoratorMode;

public class YellowShapeDecorator extends ShapeDecorator {

    public YellowShapeDecorator(Shape shape) {
        super(shape);
    }

    @Override
    public void draw() {
        super.draw();
        setColor();
    }

    public void setColor() {
        System.out.println("this is yellow");
    }
}
