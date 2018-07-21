package jdk8;

import org.junit.Test;

import java.util.*;
import java.util.function.Supplier;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class StreamsTest {

    @Test
    public void test1(){
        List<String> list = Arrays.asList("a1","a2","b1","c2","c1");
        list
//                .parallelStream()//并行流 顺序会进行改变
                .stream()//顺序流 顺序不会改变
                .filter(s -> s.startsWith("c"))
                .map(String::toUpperCase)
                .sorted()
                .forEach(System.out::println);
    }


    @Test
    public void test2(){

        Arrays.asList("a1","a2","a3","a4","a5","a6")
                .parallelStream()
                .findFirst()
                .ifPresent(System.out::println);

        Stream.of("a1","a2","a3")
                .findFirst()
                .ifPresent(System.out::println);

        IntStream.range(20,23)
                .forEach(System.out::println);

        Arrays.stream(new int[]{1, 2, 3})
                .map(n ->  n * 2 - 1)
                .average()
                .ifPresent(System.out::println);

        Stream.of("a1","a2","a3")
                .map(s -> s.substring(1))
                .mapToInt(Integer::parseInt)
                .max()
                .ifPresent(System.out::println);

        IntStream.range(1, 5)
                .mapToObj(i -> "A" + i)
                .forEach(System.out::println);

        Stream.of("a1", "s1", "b4", "v5", "87", "98")
                .filter( n -> {
                    System.out.println("filter:" + n);
                    return true;
                })
                .forEach(s -> System.out.println("forEach:" + s));

        Stream.of("s1", "a1", "b4", "v5", "87", "98")
                .map(s -> {
                    System.out.println("map:" + s);
                    return s.toUpperCase();
                })
                .anyMatch(s -> {//匹配到就会停止 map
                    System.out.println("anyMatch:" + s);
                    return s.startsWith("A");
                });

        System.out.println("----------------------");

        Stream.of("s1", "a1", "b4", "v5", "87", "98")
                .map(s -> {
                    System.out.println("map:" + s);
                    return s.toUpperCase();
                })
                .filter(s -> {
                    System.out.println("filter:" + s);
                    return s.startsWith("A");
                })
                .forEach(s -> {
                    System.out.println("forEach:" + s);
                });

        System.out.println("------------------------");
        Stream.of("s1", "a1", "b4", "v5", "87", "98")
                .sorted((s1, s2) -> {
                    System.out.printf("sort: %s; %s\n", s1, s2);
                    return s1.compareTo(s2);
                })
                .filter(s -> {
                    System.out.println("filter: " + s);
                    return s.startsWith("a");
                })
                .map(s -> {
                    System.out.println("map: " + s);
                    return s.toUpperCase();
                })
                .forEach(s -> {
                    System.out.println("forEach:" + s);
                });
    }
    /**
     * java8当调用任何的终端操作的时候
     * 流是不能重用的,流会进行关闭
     * 例如调用了anyMatch后不能再调用其他的终端操作
     * 为了避免这种现象的发生 我们可以创建一个流的供应者
     * 从供应者这里拿流
     */
    @Test
    public void test3(){
        Supplier<Stream<String>> streamSupplier =
                () -> Stream.of("s1", "a1", "b4", "v5", "87", "98")
                .filter(s -> s.startsWith("a"));
        streamSupplier.get().anyMatch(s -> true);
        streamSupplier.get().noneMatch(s -> true);

    }

    /**
     * 集合的操作
     */
    List<Persons> list = Arrays.asList(
            new Persons("tom",12),
            new Persons("jack",10),
            new Persons("tit",16),
            new Persons("ubn",10),
            new Persons("ubeng",29),
            new Persons("lili",24)
    );
    @Test
    public void test4(){
        List<Persons> t = list.stream()
                .filter(p -> p.getName().startsWith("t"))
                .collect(Collectors.toList());
        System.out.println(t);

        Map<Integer, List<Persons>> collect = list.stream()
                .collect(Collectors.groupingBy(p -> p.getAge()));
        collect.forEach((age, p) -> System.out.format("age: %s; %s \n", age, p));

        Map<Integer, String> collect1 = list.stream()
                .collect(Collectors.toMap(
                        p -> p.getAge(),
                        p -> p.getName(),
                        (name1, name2) -> name1 + ";" + name2
                ));
        System.out.println(collect1);
    }

    @Test
    public void test5(){
        long u = list.stream()
                .filter(s -> s.getName().startsWith("u"))
                .count();
        System.out.println(u);
    }

    @Test
    public void test6(){
        List<String> stringCollection = new ArrayList<>();
        stringCollection.add("ddd2");
        stringCollection.add("aaa2");
        stringCollection.add("bbb1");
        stringCollection.add("aaa1");
        stringCollection.add("bbb3");
        stringCollection.add("ccc");
        stringCollection.add("bbb2");
        stringCollection.add("ddd1");
        Optional<String> reduce = stringCollection.stream()
                .sorted()
                .reduce((a, b) -> a + "#" + b);
        reduce.ifPresent(System.out::println);
    }

}