package jdk8;

import org.junit.After;
import org.junit.Test;

import java.io.PrintStream;
import java.util.Comparator;
import java.util.function.*;

/**
 * 一、方法引用：若Lambda体中的内容已经有方法实现了，我们可以使用方法引用
 *      可以理解为方法引用是Lambda表达式中的另一种表现形式
 * 主要有三种语法格式
 *
 *  对象::实例方法名
 *
 *  类::静态方法名
 *
 *  类::实例方法名
 *
 *  注意：
 *     ①Lambda 体中调用参数列表与返回值类型，要与函数接口中抽象方法的函数列表和返回值类型保持一致！
 *     ②若Lambda参数列表中的第一参数是实例方法的调用者，而第二参数是实例方法的参数，可使用ClassName::method
 *
 * 二、构造器引用：
 *  格式： ClassName::new
 *
 *  注意：需要调用的构造器参数列表与函数式接口中抽象方法的参数保持一致
 *
 *  三、数据引用
 *  Type[]::new
 */
public class TestMethodRef {

    /**
     * 数组引用
     */
    @Test
    public void test06() {
        Function<Integer, String[]> fun = (x) -> new String[x];
        String[] apply = fun.apply(10);
        System.out.println(apply.length);

        Function<Integer, String[]> fun2 = String[]::new;
        String[] apply1 = fun2.apply(20);
        System.out.println(apply1.length);
    }

    /**
     * 构造器引用
     */
    @Test
    public void test05() {
        Supplier<Persons> su = Persons::new;
        Persons persons = su.get();
        System.out.println(persons);

        Function<Integer, Persons> fu = Persons::new;
        Persons apply = fu.apply(10);
        System.out.println(apply);

        BiFunction<String, Integer, Persons> bif = Persons::new;
        Persons bifApply = bif.apply("张三", 12);
        System.out.println(bifApply);
    }


    /**
     * 对象::实例方法名
     */
    @Test
    public void test01() {
        Consumer<String> cn = (x) -> System.out.println(x);
        cn.accept("aaaa");
        Consumer<String> cn2 = System.out::println;
        cn2.accept("bbbb");
        PrintStream out = System.out;
        Consumer<String> cn3 = out::println;
        cn3.accept("cccc");
    }

    /**
     *  对象::实例方法名
     */
    @Test
    public void test02() {
        Persons persons = new Persons();
        persons.setName("张三");
        persons.setAge(12);
        Supplier<String> su = persons::getName;
        System.out.println(su.get());
        Supplier<Integer> su2 = persons::getAge;
        System.out.println(su2.get());
    }

    /**
     *  类名::静态方法名
     */
    @Test
    public void test03() {
        Comparator<Integer> com = Integer::compare;
        int compare = com.compare(1, 2);
        System.out.println(compare);
    }

    /**
     * 类名::实例方法名
     */
    @Test
    public void test04() {
        BiPredicate<String, String> bp = (x, y) -> x.equals(y);
        BiPredicate<String, String> bp2 = String::equals;
    }

}
