package classLoader;

import org.junit.Test;

import java.lang.reflect.Method;

public class ClassLoaderTest {

    @Test
    public void test01() throws ClassNotFoundException {
        Class.forName("classLoader.ClassForName");
    }

    @Test
    public void test02() throws ClassNotFoundException {
        Class<?> aClass = ClassLoader.getSystemClassLoader().loadClass("classLoader.ClassForName");
        Method[] methods = aClass.getMethods();
        for (Method method : methods) {
            System.out.println(method);
        }
    }

}
