package designPattern.factoryMode;

/**
 * 除
 */
public class OperationDiv extends Operation{

    @Override
    public double getResult() throws Exception {
        double result = 0;
        if (this.getNum2() == 0) {
            throw new Exception("除数不能为0");
        }
        result = this.getNum1()/this.getNum2();
        return result;
    }
}
