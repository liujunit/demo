package jdk8;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

/**
 * Java8 内置四大函数
 */
public class LambdaTest05 {

    /**
     * 断言表达式 Predicate<T>
     *     boolean test(T t);
     */
    @Test
    public void test04() {
        List<Integer> intList = Arrays.asList(1, 2, 4, 5, 6, 7, 8);
        List<Integer> result = filter(intList, (a) -> a % 2 == 0);
        result.forEach(System.out::println);
    }

    public List<Integer> filter(List<Integer> intList, Predicate<Integer> pr) {
        List<Integer> list = new ArrayList<>();
        intList.forEach(x -> {
            if (pr.test(x)) list.add(x);
        });
        return list;
    }


    /**
     * 函数型接口 Function<T, R>
     * R apply(T t);
     */
    @Test
    public void test03() {
        String handler = strHandler("\t\t\t你好测试", (str) -> str.trim());
        System.out.println(handler);
    }

    public String strHandler(String str, Function<String, String> fun) {
        return fun.apply(str);
    }

    /**
     * 供给型接口 Supplier<T>
     * T get();
     */
    @Test
    public void test02() {
        List<Integer> list = getNumberList(10, () -> (int) (Math.random() * 100));
        list.forEach(System.out::println);
    }

    public List<Integer> getNumberList(int num, Supplier<Integer> su) {
        List<Integer> result = new ArrayList<>();
        for (int i = 0; i < num; i++) {
            Integer integer = su.get();
            result.add(integer);
        }
        return result;
    }


    /**
     * 消费型接口 Consumer<T>
     * void accept(T t);
     */
    @Test
    public void test01() {
        double d = 1000;
        happy(d, (a) -> System.out.println("发哥出去消费了：" + a));
    }

    public void happy(double d, Consumer<Double> cs) {
        cs.accept(d);
    }

}
