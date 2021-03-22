package juc;

import java.util.concurrent.CountDownLatch;

public class TestCountDownLatch {

    public static void main(String[] args) throws InterruptedException {
        long start = System.currentTimeMillis();
        final CountDownLatch latch = new CountDownLatch(5);
        LatchDemo latchDemo = new LatchDemo(latch);
        for (int i = 0; i < 5; i++) {
            new Thread(latchDemo).start();
        }
        latch.await();
        long end = System.currentTimeMillis();
        System.out.println("耗时：" + (end - start));
    }


}

class LatchDemo implements Runnable {

    private CountDownLatch latch;

    public LatchDemo(CountDownLatch latch) {
        this.latch = latch;
    }

    @Override
    public void run() {
        synchronized (this) {
            try {
                for (int i = 0; i < 500000; i++) {
                    if (i % 2 == 0) {
                        System.out.println(i);
                    }
                }
            } finally {
                latch.countDown();
            }
        }
    }
}
