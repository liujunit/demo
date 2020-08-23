package jdk8;

import org.junit.Test;

public class LambdaTest04 {

    @Test
    public void test01() {
        String a = "adfsdfdsf";
        String result = convert(a, x -> x.toUpperCase());
        System.out.println(result);
    }

    public String convert(String str, MyFun2 mf) {
        return mf.revert(str);
    }

    @Test
    public void test02() {
        long l1 = 200;
        long l2 = 100;
        long compute = compute(l1, l2, (o1, o2) -> o1 * o2);
        System.out.println(compute);
    }

    public long compute(long l1, long l2, MyFun3<Long, Long> mf) {
        return mf.getValue(l1, l2);
    }

}
