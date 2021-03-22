package juc;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class TestLock {

    public static void main(String[] args) {
        ThreadDemo1 threadDemo = new ThreadDemo1();
        new Thread(threadDemo, "1号窗口").start();
        new Thread(threadDemo, "2号窗口").start();
        new Thread(threadDemo, "3号窗口").start();
    }

}

class ThreadDemo1 implements Runnable{

    private int tick = 1000;

    private Lock lock = new ReentrantLock();

    @Override
    public void run() {
        while (true) {
            lock.lock();
            try {
                if (tick > 0) {
                    try {
                        Thread.sleep(20);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println(Thread.currentThread().getName() + " 余票：" + --tick);
                }
            } finally {
                lock.unlock();
            }
        }

    }
}
