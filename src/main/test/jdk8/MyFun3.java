package jdk8;

@FunctionalInterface
public interface MyFun3<T, R> {
    R getValue(T t1, T t2);
}
