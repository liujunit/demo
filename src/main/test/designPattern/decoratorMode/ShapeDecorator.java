package designPattern.decoratorMode;

public abstract class ShapeDecorator implements Shape {

    protected Shape decoratorShape;

    public ShapeDecorator(Shape shape) {
        this.decoratorShape = shape;
    }

    public void draw() {
        decoratorShape.draw();
    }

}
