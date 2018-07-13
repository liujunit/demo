package jdk8;

import org.junit.Test;

import java.util.*;

/**
 * Lambda表达式
 */
public class LambdaTest {
    /**
     * 排序
     */
    @Test
    public void test1(){
        List<String> list  = Arrays.asList("peter","jack","lili","tom");
        //java8之前
//        Collections.sort(list, new Comparator<String>() {
//            @Override
//            public int compare(String o1, String o2) {
//                return o1.compareTo(o2);
//            }
//        });
        //java8
//        Collections.sort(list, (String a, String b) -> {
//            return a.compareTo(b);
//        });
        //简化
//        Collections.sort(list, (String a, String b) -> b.compareTo(a));
        //在简化
        list.sort((a, b) -> a.compareTo(b));
        System.out.println(list);
    }

    /**
     * 功能性接口测试
     */
    @Test
    public void test2(){
//        Converter<String, Integer> converter = from -> Integer.valueOf(from);
        //进一步的简化
        Converter<String, Integer> converter = Integer::valueOf;
        Integer convert = converter.convert("234");
        System.out.println(convert);
    }

    /**
     * ::关键字传递对象 方法
     */
    @Test
    public void test3(){
        Something something = new Something();
        Converter<String, String> converter = something::startWith;
        String java = converter.convert("Java");
        System.out.println(java);
    }

}
//功能性接口 注释可以省略
//@FunctionalInterface
interface Converter<F, T> {
    T convert(F from);
}

class Something{
    String startWith(String s){
        return String.valueOf(s.charAt(0));
    }
}