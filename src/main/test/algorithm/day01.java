package algorithm;

import org.junit.Test;

/**
 * 对于长度为5位的一个01串，每一位都可能是0或1，一共有32种可能。它们的前几个是：
 * 00000
 * 00001
 * 00010
 * 00011
 * 00100
 * 请按从小到大的顺序输出这32种01串。
 * 输入格式
 * 本试题没有输入。
 * 输出格式
 * 输出32行，按从小到大的顺序每行一个长度为5的01串。
 * 样例输出
 * 00000
 * 00001
 * 00010
 * 00011
 * <以下部分省略>
 */
public class day01 {

    @Test
    public void test1() {
        for (int i = 0; i < 32; i++) {
            //获取对应数字的二进制字符串
            String result = Integer.toBinaryString(i);
            int num = result.length();
            for (int j = 0; j < 5 - num; j++) {
                result = "0" + result;
            }
            System.out.println(result);
        }
    }

    @Test
    public void test2(){
        for (int i = 0; i < 32; i++) {
            String result = Integer.toBinaryString(i);
            int length = result.length();
            switch (length){
                case 1:
                    result = "0000" + result;
                    break;
                case 2:
                    result = "000" + result;
                    break;
                case 3:
                    result = "00" + result;
                    break;
                case 4:
                    result = "0" + result;
            }
            System.out.println(result);
        }
    }
}
