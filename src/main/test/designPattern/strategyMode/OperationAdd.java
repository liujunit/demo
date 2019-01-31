package designPattern.strategyMode;

public class OperationAdd implements Strategy {
    @Override
    public double getResult(double num1, double num2) {
        return num1 + num2;
    }
}
