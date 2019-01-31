package designPattern.factoryMode;

/**
 * 减法运算类
 */
public class OperationSub extends Operation {

    @Override
    public double getResult() {
        double result = 0;
        result = this.getNum1() - this.getNum2();
        return result;
    }
}
