package javase;

import java.lang.reflect.Method;

public class ClassDemo {

    public static void main(String[] args) {
        try {
            String className = "javase.CloneDemo";
            Class<?> aClass = Class.forName(className);
            CloneDemo cloneDemo = (CloneDemo) aClass.newInstance();
            System.out.println(cloneDemo);
            System.out.println("*************");
            Class<?>[] interfaces = aClass.getInterfaces();
            for (Class<?> anInterface : interfaces) {
                String name = anInterface.getName();
                System.out.println(name);
                System.out.println("-----");
            }
            Method[] methods = aClass.getMethods();
            for (Method method : methods) {
                System.out.println(method.getName());
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        }
    }

}
