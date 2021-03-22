package jdk8;

import org.junit.Test;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * 一、Stream操作的三个步骤
 * 1.创建Stream
 *
 *
 * 2.中间操作
 *      筛选与切片
 *      filter：接收Lambda，从流中排除某些元素
 *      limit: 截断流，使其元素不超过给定数量
 *      skip(n)：跳过元素，返回一个扔掉了前n个元素的流，若流中元素不足n个，则返回一个空流，与limit(n)互补
 *      distinct: 筛选，通过流所生成元素的hashCode()和equals()去处重复元素
 *
 *      映射
 *      map: 接收Lambda，将元素转换成其他形式或提取信息。接收一个函数作为参数，该函数会被应用到每个元素上，并将其映射成一个新的元素
 *      flatMap：接收一个函数作为参数，将流中的每个值都换成另一个流，然后把所有流连城一个流
 *
 *      排序
 *      sorted() 自然排序
 *      sorted(Comparator com) 定制排序
 *
 *
 *
 *
 *
 * 3.终止操作（终端操作）
 *
 *      查找与匹配
 *      allMatch：检查是否匹配所有元素
 *      anyMatch：检查是否至少匹配一个元素
 *      noneMatch：检查是否没有匹配所有元素
 *      findFirst：返回第一个元素
 *      findAny：返回当前流中的任意元素
 *      count：返回流中元素的总数
 *      max：返回流中最大值
 *      min：返回流中最小值
 *
 *     规约
 *     reduce(T identity, BinaryOperation)/reduce(BinaryOperation) 可以将流中的元素反复结合起来，得到一个值
 *
 *     收集
 *     collect 将流转换为其他形式。接收一个Collector接口的实现，用于给Stream中元素做汇总的方法
 *
 */
public class TestStreamAPI1 {

    List<Persons> personList = Arrays.asList(
            new Persons("张三", 19, 1111.22, Persons.Status.BUSY),
            new Persons("李四", 28, 2222.22, Persons.Status.FREE),
            new Persons("王五", 38, 3333.22, Persons.Status.VOCATION),
            new Persons("赵六", 19, 4444.22, Persons.Status.BUSY),
            new Persons("田七", 21, 5555.22, Persons.Status.FREE),
            new Persons("孙八", 24, 6666.22, Persons.Status.BUSY),
            new Persons("孙八", 24, 6666.22, Persons.Status.BUSY)
    );

    @Test
    public void test12() {
        String collect = personList.stream()
                .map(Persons::getName)
                .distinct()
                .collect(Collectors.joining(",", "start", "end"));
        System.out.println(collect);
    }

    @Test
    public void test11() {
        //分组
        Map<Persons.Status, List<Persons>> collect = personList.stream()
                .collect(Collectors.groupingBy(Persons::getStatus));
        System.out.println(collect);
        //多级分组
        Map<Persons.Status, Map<String, List<Persons>>> collect1 = personList.stream()
                .collect(Collectors.groupingBy(Persons::getStatus, Collectors.groupingBy(p -> {
                    if (p.getAge() < 25) {
                        return "青年";
                    } else if (p.getAge() >= 25 && p.getAge() < 35) {
                        return "中年";
                    } else {
                        return "老年";
                    }
                })));
        System.out.println(collect1);
        //分区
        Map<Boolean, List<Persons>> collect2 = personList.stream()
                .collect(Collectors.partitioningBy(p -> p.getSalary() > 4000));
        System.out.println(collect2);
    }

    @Test
    public void test10() {
        //总数
        Long collect = personList.stream()
                .collect(Collectors.counting());
        System.out.println(collect);
        //平均值
        Double collect1 = personList.stream()
                .collect(Collectors.averagingDouble(Persons::getSalary));
        System.out.println(collect1);
        //总和
        Double collect2 = personList.stream()
                .collect(Collectors.summingDouble(Persons::getSalary));
        System.out.println(collect2);
        //最大值
        Optional<Persons> collect3 = personList.stream()
                .collect(Collectors.maxBy((p1, p2) -> Double.compare(p1.getSalary(), p2.getSalary())));
        System.out.println(collect3.get());
        //最小值
        Optional<Integer> collect4 = personList.stream()
                .map(Persons::getAge)
                .collect(Collectors.minBy(Integer::compareTo));
        System.out.println(collect4.get());
    }


    @Test
    public void test09() {
        List<String> collect = personList.stream()
                .map(Persons::getName)
                .collect(Collectors.toList());
        System.out.println(collect);
        Set<String> collect1 = personList.stream()
                .map(Persons::getName)
                .collect(Collectors.toSet());
        System.out.println(collect1);
        HashSet<String> collect2 = personList.stream()
                .map(Persons::getName)
                .collect(Collectors.toCollection(HashSet::new));
        System.out.println(collect2);
    }

    @Test
    public void test08() {
        List<Integer> list = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9);
        Integer reduce = list.stream()
                .reduce(0, (x, y) -> x + y);
        System.out.println(reduce);
        System.out.println("------------------------------------------");
        Optional<Integer> reduce1 = list.stream()
                .reduce((x, y) -> x + y);
        System.out.println(reduce1.get());
        System.out.println("------------------------------------------");
        Optional<Double> reduce2 = personList.stream()
                .map(Persons::getSalary)
                .reduce(Double::sum);
        System.out.println(reduce2.get());
    }

    @Test
    public void test07() {
        boolean b1 = personList.stream()
                .allMatch((p) -> p.getStatus().equals(Persons.Status.BUSY));
        System.out.println(b1);
        boolean b2 = personList.stream()
                .anyMatch((p) -> p.getStatus().equals(Persons.Status.BUSY));
        System.out.println(b2);
        boolean b3 = personList.stream()
                .noneMatch((p) -> p.getStatus().equals(Persons.Status.BUSY));
        System.out.println(b3);
        Optional<Persons> op = personList.stream()
                .sorted((p1, p2) -> -Double.compare(p1.getSalary(),p2.getSalary()))
                .findFirst();
        System.out.println(op.get());
        Optional<Persons> op2 = personList.parallelStream()
                .findAny();
        System.out.println(op2.get());
        long count = personList.stream()
                .count();
        System.out.println(count);
        Optional<Persons> op3 = personList.stream()
                .max((p1, p2) -> Double.compare(p1.getSalary(), p2.getSalary()));
        System.out.println(op3.get());
        Optional<Integer> op4 = personList.stream()
                .map(Persons::getAge)
                .min(Integer::compareTo);
        System.out.println(op4.get());
    }

    @Test
    public void test06() {
        List<String> list = Arrays.asList("cc", "bb", "dd", "aa", "ee", "ff");
        list.stream()
                .sorted()
                .forEach(System.out::println);
        System.out.println("----------------------------------------------------");
        personList.stream()
                .sorted((p1, p2) -> {
                    if (p1.getAge() == p2.getAge()) {
                        return p1.getName().compareTo(p2.getName());
                    } else {
                        return -Integer.compare(p1.getAge(), p2.getAge());
                    }
                })
                .forEach(System.out::println);
    }


    @Test
    public void test05() {
        List<String> list = Arrays.asList("aa", "bb", "cc", "dd", "ee", "ff");
        list.stream()
                .map((str) -> str.toUpperCase())
                .forEach(System.out::println);
        System.out.println("----------------------------------------------------");
        personList.stream()
                .map((p) -> p.getName())
                .forEach(System.out::println);
        System.out.println("----------------------------------------------------");
        Stream<Stream<Character>> streamStream = list.stream()
                .map(TestStreamAPI1::filterCharacter);
        streamStream.forEach((stream) -> {
            stream.forEach((System.out::println));
        });
        System.out.println("----------------------------------------------------");
        list.stream()
                .flatMap(TestStreamAPI1::filterCharacter)
                .forEach(System.out::println);
    }

    public static Stream<Character> filterCharacter(String str) {
        List<Character> list = new ArrayList<>();
        for (char ch : str.toCharArray()) {
            list.add(ch);
        }
        return list.stream();
    }

    @Test
    public void test04() {
        personList.stream()
                .filter((p) -> p.getSalary() > 3000)
                .skip(2)
                .distinct()
                .forEach(System.out::println);
    }

    @Test
    public void test03() {
        personList.stream()
                .filter((p) -> {
                    System.out.println("短路");
                    return p.getSalary() > 3000;
                })
                .limit(2)
                .forEach(System.out::println);
    }


    @Test
    public void test02() {
        //中间操作：不会执行任何操作
        Stream<Persons> stream = personList.stream()
                .filter((p) -> {
                    System.out.println("开始进行判断");
                    return p.getAge() > 25;
                });
        //终止操作：一次性执行全部内容，即“惰性求值”
        stream.forEach(System.out::println);
    }


    /**
     * Stream的创建
     */
    @Test
    public void test01() {
        //1.Collection集合提供的串行流stream()或并行流parallelStream()
        List<String> strList = new ArrayList<>();
        Stream<String> stream = strList.stream();
        //2.通过Arrays的静态方法获取数组流
        Persons[] persons = new Persons[10];
        Stream<Persons> stream1 = Arrays.stream(persons);
        //3.通过Stream类中静态方法of()
        Stream<String> stream2 = Stream.of("aa", "bb", "cc");
        //4.创建无限流
        //迭代
        Stream<Integer> iterate = Stream.iterate(0, (x) -> x + 2);
        iterate.limit(10).forEach(System.out::println);
        //生成
        Stream.generate(() -> Math.random())
                .limit(10)
                .forEach(System.out::println);
    }

}
