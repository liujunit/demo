package algorithm;

import org.junit.Test;

public class day04 {

    /**
     * ^异或运算
     * 相同为0
     * 不同为1
     */
    @Test
    public void test01() {
        System.out.println(2^3);
        System.out.println(3^3);
    }

    /**
     * &与运算
     * 操作位数 同为1则为1 有一个为0则为0
     */
    @Test
    public void test02() {
        System.out.println(2&3);
        System.out.println(6&4);
    }

}
