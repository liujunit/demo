package jdk8;

import org.junit.Test;

import java.math.BigDecimal;
import java.text.DecimalFormat;

public class LambdaTest03 {

    DecimalFormat df =new DecimalFormat("###,###.00");

    @Test
    public void test01() {
        BigDecimal a = new BigDecimal("2020192.235");
        String result = formatBigDecimal(a, (b, df) -> df.format(b));
        System.out.println(result);
    }

    public String formatBigDecimal(BigDecimal a, MyFun mf) {
        return mf.format(a, df);
    }

    @Test
    public void test02() {
        BigDecimal a = new BigDecimal(10);
        BigDecimal b = new BigDecimal(4);
        BigDecimal divide = a.divide(b, BigDecimal.ROUND_HALF_UP);
        System.out.println(divide.toString());
    }

}
