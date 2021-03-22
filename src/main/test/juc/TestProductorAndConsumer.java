package juc;

public class TestProductorAndConsumer {

    public static void main(String[] args) {
        Clerk clerk = new Clerk();
        Productor productor = new Productor(clerk);
        Consumer consumer = new Consumer(clerk);
        new Thread(productor, "生产者A").start();
        new Thread(consumer, "消费者A").start();
        new Thread(productor, "生产者B").start();
        new Thread(consumer, "消费者B").start();
    }

}

class Clerk {
    private int product = 0;

    //生产
    public synchronized void get() {
        while (product >= 1) {//避免虚假唤醒 这里不可以用if
            System.out.println("满货！");
            try {
                this.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println(Thread.currentThread().getName() + ":" + ++product);
        this.notifyAll();
    }

    //卖货
    public synchronized void sale() {
        while (product <= 0) {
            System.out.println("缺货！");
            try {
                this.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println(Thread.currentThread().getName() + ":" + --product);
        this.notifyAll();
    }
}

/**
 * 生产者
 */
class Productor implements Runnable {

    private Clerk clerk;

    public Productor(Clerk clerk) {
        this.clerk = clerk;
    }

    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            clerk.get();
        }
    }
}

/**
 * 消费者
 */
class Consumer implements Runnable {

    private Clerk clerk;

    public Consumer(Clerk clerk) {
        this.clerk = clerk;
    }

    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            clerk.sale();
        }
    }

}