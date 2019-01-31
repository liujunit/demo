package designPattern.factoryMode;

public class OperationTest {

    public static void main(String[] args) throws Exception {
        Operation operation = OperationFactory.createOperation("+");
        operation.setNum1(1);
        operation.setNum2(2);
        System.out.println(operation.getResult());

    }

}
