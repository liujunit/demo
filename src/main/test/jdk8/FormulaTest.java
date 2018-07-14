package jdk8;

public class FormulaTest {

    public static void main(String[] args){
        Formula formula = new Formula() {
            @Override
            public double caculate(int a) {
                return a*100;
            }
        };
        double caculate = formula.caculate(10);
        double sqrt = formula.sqrt(100);
        System.out.println(caculate);
        System.out.println(sqrt);

        Formula formula1 = new FormulaImp();
        double caculate1 = formula1.caculate(10);
        double sqrt1 = formula1.sqrt(10000);
        System.out.println(caculate1);
        System.out.println(sqrt1);

        Formula formula2 = i -> (i*1000);
        double caculate2 = formula2.caculate(10);
        double sqrt2 = formula2.sqrt(100);
        System.out.println(caculate2);
        System.out.println(sqrt2);

        SomeChange someChange = new SomeChange();
        Formula formula3 = someChange::getMin;
        double caculate3 = formula3.caculate(1000);
        System.out.println(caculate3);


    }
}

class FormulaImp implements Formula{
    @Override
    public double sqrt(int a) {
        return 0;
    }

    @Override
    public double caculate(int a) {
        return a*11;
    }
}

class SomeChange{

    double getMin(int i){
        return Math.min(i, 100);
    }

}