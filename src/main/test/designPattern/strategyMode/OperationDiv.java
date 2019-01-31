package designPattern.strategyMode;

public class OperationDiv implements Strategy {
    @Override
    public double getResult(double num1, double num2) throws Exception {
        if (num2 == 0) {
            throw new Exception("除数不能为0");
        }
        return num1 / num2;
    }
}
