package designPattern.proxyMode;

public class RealSubject implements Subject {

    @Override
    public int sellBook() {
        System.out.println("正在卖书。");
        return 1;
    }

    @Override
    public String speak() {
        System.out.println("正在说话。");
        return "说话";
    }
}
