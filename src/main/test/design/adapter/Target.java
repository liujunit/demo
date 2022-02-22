package design.adapter;

public class Target extends Source implements Adapter{

    @Override
    public void method2() {
        System.out.println("method2 start");
    }

}
