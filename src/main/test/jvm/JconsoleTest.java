package jvm;

import java.util.ArrayList;
import java.util.List;

public class JconsoleTest {

    private byte[] jbyte = new byte[128 * 1024];

    public static void main(String[] args) throws InterruptedException {
        Thread.sleep(5000);
        System.out.println("start .. ");
        create(1000);
    }

    private static void create(int count) throws InterruptedException {
        List<JconsoleTest> list = new ArrayList<>();
        for (int i = 0; i < count; i++){
            Thread.sleep(100);
            list.add(new JconsoleTest());
        }
    }

}
