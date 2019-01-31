package designPattern.factoryMode;

/**
 * 工厂模式
 * 工厂模式是最常用的模式之一，这种类型的设计模式属于创建型模式，提供了一种创建对象的最佳方法。
 * 在工厂模式中，我们创建对象时，不会对客户端暴露创建逻辑，并且通过一个共同的接口来指向新创建的对象。
 *
 */
public class OperationFactory {

    public static Operation createOperation(String oper) {
        Operation operation = null;
        switch (oper) {
            case "+":
                operation = new OperationAdd();
                break;
            case "-":
                operation = new OperationSub();
                break;
            case "*":
                operation = new OperationMul();
                break;
            case "/" :
                operation = new OperationDiv();
                break;
        }
        return operation;
    }

}
