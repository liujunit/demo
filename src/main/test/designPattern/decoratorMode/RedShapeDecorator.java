package designPattern.decoratorMode;

public class RedShapeDecorator extends ShapeDecorator {

    public RedShapeDecorator(Shape shape) {
        super(shape);
    }

    @Override
    public void draw() {
        super.draw();
        setColor(super.decoratorShape);
    }

    public void setColor(Shape decoratorShape) {
        System.out.println("color: red");
    }
}
