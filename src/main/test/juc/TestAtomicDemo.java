package juc;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * volatile 保证内存的可见性，不能保证原子性
 * java.util.concurrent.atomic，提供了常用的原子变量
 * CAS 保证了数据的原子性
 * CAS 包含了三个操作数：内存值V 预估值A 更新值B 当且仅当V==A时，V=B否则将不做任何操作
 */
public class TestAtomicDemo {

    public static void main(String[] args) {
        ThreadAtomicDemo atomicDemo = new ThreadAtomicDemo();
        for (int i = 0; i < 10; i++) {
            Thread t = new Thread(atomicDemo);
            t.start();
        }
    }

}

class ThreadAtomicDemo implements Runnable {

//    private volatile int serialNumber = 0;
    private AtomicInteger serialNumber = new AtomicInteger(0);

    @Override
    public void run() {
        try {
            Thread.sleep(200);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(getSerialNumber());
    }

    public int getSerialNumber() {
        return serialNumber.getAndIncrement();
    }
}