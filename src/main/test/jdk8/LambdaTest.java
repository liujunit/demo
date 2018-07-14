package jdk8;

import org.junit.Test;

import java.util.*;
import java.util.function.Predicate;

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

    /**
     * ::用法
     */
    @Test
    public void test4(){
        PersonFactory<Person> personFactory = Person::new;
        Person person = personFactory.create("L", "jun");
    }

    @Test
    public void test5(){
        final int num = 5;
        Converter<Integer, String> converter = (from) -> String.valueOf(from + num);
        String convert = converter.convert(6);
        System.out.println(convert);
    }

    @Test
    public void test6(){
        Predicate<String> predicate = i -> i.length()>0;
        System.out.println(predicate.test("123"));
        System.out.println(predicate.negate().test("123"));

        Predicate<Boolean> predicate1 = Objects::isNull;
        Predicate<Boolean> predicate2 = Objects::nonNull;
    }

    @Test
    public void test7(){
        Optional<String> optional = Optional.of("123");
        System.out.println(optional.isPresent());
        System.out.println(optional.orElse("t"));
        System.out.println(optional.get());
        optional.ifPresent(s -> System.out.println(s.charAt(0)));
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

class Person{
    private String firstName;
    private String lastName;

    Person(){}

    Person(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }
}

interface PersonFactory<P extends Person>{
    P create(String firstName, String lastName);
}