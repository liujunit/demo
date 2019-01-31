package designPattern.factoryMode;

/**
 * 乘
 */
public class OperationMul extends Operation {

    @Override
    public double getResult() {
        double result = 0;
        result = this.getNum1() * this.getNum2();
        return result;
    }
}
