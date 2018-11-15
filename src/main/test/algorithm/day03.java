package algorithm;

/**
 * 欧几里得算法
 * 求两个非负整数的最大公约数
 */
public class day03 {

    public static void main(String[] args) {
        System.out.println(gcd(10, 2));
    }

    public static int gcd(int a, int b){
        if (b == 0) return a;
        int c = a % b;
        return gcd(b, c);
    }

}
