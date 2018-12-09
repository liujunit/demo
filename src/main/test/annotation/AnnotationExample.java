package annotation;

import java.util.ArrayList;
import java.util.List;

public class AnnotationExample {

    public static void main(String[] args) {
        test();
    }

    @Override
    @MyFirstAnnotaion(name = "zhangsan", data = "2018-10-10", describe = "is a good boy")
    public String toString() {
        return "AnnotationExample toString";
    }

    @Deprecated
    @MyFirstAnnotaion(name = "oldMethod", data = "2018-10-11", describe = "is a old method")
    public static void oldMethod() {
        System.out.println("it is a old method");
    }

    @SuppressWarnings({"unchecked", "deprecation"})
    @MyFirstAnnotaion(name = "test", data = "2018-1-1", describe = "is a test method")
    public static void test() {
        List list = new ArrayList();
        list.add(1);
        oldMethod();
    }

}
