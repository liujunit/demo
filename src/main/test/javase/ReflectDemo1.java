package javase;

import sun.reflect.misc.ReflectUtil;

import java.lang.reflect.Field;

public class ReflectDemo1 {

    private int count;

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public static void main(String[] args) {
        try {
            ReflectDemo1 reflectDemo1 = new ReflectDemo1();
            reflectDemo1.setCount(10);
            Class<?> aClass = Class.forName("javase.ReflectDemo1");
            Field count = aClass.getDeclaredField("count");
            int anInt = count.getInt(reflectDemo1);
            System.out.println(reflectDemo1.getCount());
            System.out.println("----------------------");
            count.setInt(reflectDemo1, 11);
            System.out.println(reflectDemo1.getCount());
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (NoSuchFieldException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
    }
}
