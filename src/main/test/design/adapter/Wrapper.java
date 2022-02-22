package design.adapter;

public class Wrapper implements Adapter{

    private Source source;

    public Wrapper(Source source) {
        this.source = source;
    }

    @Override
    public void method1() {
        source.method1();
    }

    @Override
    public void method2() {
        System.out.println("wrapper method2 start");
    }
}
