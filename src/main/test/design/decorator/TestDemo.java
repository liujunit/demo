package design.decorator;

public class TestDemo {

    public static void main(String[] args) {
        Shape redCircle = new RedShapeDecorator(new Circle());
        Shape redRectangle = new RedShapeDecorator(new Rectangle());
        redCircle.draw();
        System.out.println("---------------------");
        redRectangle.draw();
    }

}
