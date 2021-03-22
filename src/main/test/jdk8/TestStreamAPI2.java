package jdk8;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class TestStreamAPI2 {
    /**
     * 1.给定一个数字列表，如何返回一个由每个数的平方构成的列表呢？
     * 给定【1,2,3,4,5】 返回【1,4,9,16,25】
     */
    @Test
    public void test01() {
        List<Integer> list = Arrays.asList(1, 2, 3, 4, 5);
        List<Integer> collect = list.stream()
                .map((x) -> x * x)
                .collect(Collectors.toList());
        System.out.println(collect);
    }

    List<Persons> personList = Arrays.asList(
            new Persons("张三", 19, 1111.22, Persons.Status.BUSY),
            new Persons("李四", 28, 2222.22, Persons.Status.FREE),
            new Persons("王五", 38, 3333.22, Persons.Status.VOCATION),
            new Persons("赵六", 19, 4444.22, Persons.Status.BUSY),
            new Persons("田七", 21, 5555.22, Persons.Status.FREE),
            new Persons("孙八", 24, 6666.22, Persons.Status.BUSY),
            new Persons("孙八", 24, 6666.22, Persons.Status.BUSY)
    );

    /**
     * 2.用map和reduce计算集合中的个数
     */
    @Test
    public void test02() {
        Optional<Integer> reduce = personList.stream()
                .map(p -> 1)
                .reduce(Integer::sum);
        System.out.println(reduce.get());
    }

}
