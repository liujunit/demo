package designPattern.strategyMode;

/**
 * 策略模式
 *一个类的行为或算法可以在运行的时候改变，这种类型的设计模式属于行为型模式。
 * 在策略模式中，我们创建各种策略的对象和行为随着策略对象的改变而改变。
 * 策略对象改变，Context的执行的算法就会改变。
 *
 */
public class Context {

    private Strategy strategy;

    public Context(Strategy strategy) {
        this.strategy = strategy;
    }

    public double getResult(double num1, double num2) throws Exception {
        return strategy.getResult(num1, num2);
    }

}
