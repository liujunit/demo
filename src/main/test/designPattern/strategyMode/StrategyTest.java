package designPattern.strategyMode;

public class StrategyTest {

    public static void main(String[] args) throws Exception {
        Context context1 = new Context(new OperationAdd());
        System.out.println("加：" + context1.getResult(1, 2));
        Context context2 = new Context(new OperationSub());
        System.out.println("减：" + context2.getResult(1, 2));
    }
}
