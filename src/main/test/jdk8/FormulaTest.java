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
