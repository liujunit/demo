package design.adapter;

public class TestDemo {

    public static void main(String[] args) {
        Adapter target = new Target();
        target.method1();
        target.method2();

        System.out.println("------------------------------------");

        Adapter wrapper = new Wrapper(new Source());
        wrapper.method1();
        wrapper.method2();

        System.out.println("------------------------------------");

        Adapter source1 = new Source1();
        Adapter source2 = new Source2();

        source1.method1();
        source1.method2();
        source2.method1();
        source2.method2();
    }

}
