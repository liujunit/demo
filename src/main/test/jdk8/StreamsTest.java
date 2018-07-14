package jdk8;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;
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
    }
}
