package jdk8;

import org.junit.Test;

import java.util.Optional;

/**
 * Optional 容器类的常用方法
 *      Optional.of(T t): 创建一个Optional实例
 *      Optional.empty(): 创建一个空的Optional实例
 *      Optional.ofNullable(T t): 若t不为null，创建Optional实例，否则创建空实例
 *      isPresent(): 判断是否包含值
 *      orElse(T t): 如果调用对象包含值，返回该值，否则返回t
 *      orElseGet(Supplier s): 如果调用对象包含值，返回该值，否则返回s 获取的值
 *      map（Function f）: 如果有值对其处理，并返回处理后的Optional，否则返回Optional.empty()
 *      flatMap(Function map): 与map类似，要求返回值必须是Optional
 */
public class TestOptional {

    @Test
    public void test02() {
        Optional<Persons> op = Optional.ofNullable(null);
//        if (op.isPresent()) {
//            System.out.println(op.get());
//        }
        Persons persons = op.orElse(new Persons());
        System.out.println(persons);
    }

    @Test
    public void test01() {
        Optional<Persons> op = Optional.ofNullable(new Persons());
        Persons persons = op.get();
        System.out.println(persons);
    }

}
