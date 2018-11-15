package demo;

/**
 * 正则表达式测试
 */
public class RegDemo {

    public static void main(String[] args) {

        String reg = "[^d\\(\\)\\.]+";
        String str1 = "25.73(3)";
        String str2 = "一、 1∶5万地质填图";
        System.out.println(str1.matches(reg));
        System.out.println(str2.matches(reg));

        String test = "地质灾害   调查  榆林市   靖边县";
        System.out.println(test.replaceAll("\\s+",","));
    }
}
