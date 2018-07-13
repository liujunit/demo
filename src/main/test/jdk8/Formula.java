package jdk8;

/**
 * java8 接口新增默认方法
 */
public interface Formula {

    double caculate(int a);

    default double sqrt(int a){
        return Math.sqrt(a);
    }
}
