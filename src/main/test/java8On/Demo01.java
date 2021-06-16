package java8On;

import java.util.Set;

public class Demo01 {

    public static void main(String[] args) {
        Set<Object> objects = System.getProperties().keySet();
        for (Object object : objects) {
            System.out.println(object);
        }
        System.out.println("----------------------------------------");
        System.out.println(System.getProperty("os.name"));
        System.out.println(System.getProperty("user.name"));
        System.out.println(System.getProperty("java.library.path"));
        System.out.println("----------------------------------------");
        System.getProperties().list(System.out);
    }

}
