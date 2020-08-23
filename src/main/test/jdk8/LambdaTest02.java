package jdk8;

import org.junit.Test;

import java.util.*;

public class LambdaTest02 {

    @Test
    public void test01() {
        Comparator<Integer> cm = new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return 0;
            }
        };
        TreeSet<Integer> treeSet2 = new TreeSet<>((o1, o2) -> Integer.compare(o1, o2));
        Comparator<Integer> cm2 = (x, y) -> Integer.compare(x, y);
    }

    List<Persons> personList = Arrays.asList(
            new Persons("张三", 19, 1111.22),
            new Persons("李四", 28, 2222.22),
            new Persons("王五", 38, 3333.22),
            new Persons("赵六", 19, 4444.22),
            new Persons("田七", 21, 5555.22),
            new Persons("孙八", 24, 6666.22)
    );

    @Test
    public void test05() {
        Collections.sort(personList, (x, y) -> {
            if (x.getAge() > y.getAge()) {
                return 1;
            } else if (x.getAge() < y.getAge()) {
                return -1;
            } else {
                return  y.getName().chars().sum() - x.getName().chars().sum();
            }
        });
        personList.stream()
                .forEach(System.out::println);
    }


    @Test
    public void test02() {
        List<Persons> personList = getPersonList(this.personList);
        System.out.println(personList);
    }

    @Test
    public void test03() {
        List<Persons> personsList = filterPersonList(personList, o -> o.getAge() > 20);
        personsList.forEach(System.out::println);
    }

    @Test
    public void test04() {
        personList.stream()
                .filter(o -> o.getAge() > 20)
                .limit(10)
                .forEach(System.out::println);

        personList.stream()
                .map(o -> o.getName())
                .forEach(System.out::println);
    }

    public List<Persons> filterPersonList(List<Persons> list, MyPredicate<Persons> mp) {
        List<Persons> result = new ArrayList<>();
        for (Persons persons : list) {
            if (mp.test(persons)) {
                result.add(persons);
            }
        }
        return result;
    }

    public List<Persons> getPersonList(List<Persons> list) {
        List<Persons> result = new ArrayList<>();
        for (Persons persons : list) {
            if (persons.getAge() > 25) {
                result.add(persons);
            }
        }
        return result;
    }

}
