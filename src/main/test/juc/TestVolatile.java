package juc;

/**
 * volatile: 保证多个线程访问共享数据时，内存的可见性
 *          相较与synchronized是一种较为轻量级的同步策略
 *注意：
 * 1.volatile不具备互斥性
 * 2.volatile不能保证变量的原子性
 *
 */
public class TestVolatile {

    public static void main(String[] args) {
        ThreadDemo threadDemo = new ThreadDemo();
        Thread t1 = new Thread(threadDemo);
        t1.start();
        while (true) {
            System.out.println(threadDemo.isFlag());
            synchronized (threadDemo) {
                if (threadDemo.isFlag()) {
                    System.out.println("=====================");
                    break;
                }
            }
        }
    }

}

class ThreadDemo implements Runnable{

    private volatile boolean flag = false;

    @Override
    public void run() {
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        flag = true;
        System.out.println("flag=" + flag);
    }

    public boolean isFlag() {
        return flag;
    }

    public void setFlag(boolean flag) {
        this.flag = flag;
    }
}
