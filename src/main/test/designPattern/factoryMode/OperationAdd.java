package designPattern.factoryMode;

/**
 * 加法 运算类
 */
public class OperationAdd extends Operation {

    @Override
    public double getResult() {
        double result = 0;
        result = this.getNum1() + this.getNum2();
        return result;
    }
}
