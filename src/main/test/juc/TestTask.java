package juc;

import org.junit.Test;

import java.util.concurrent.*;

public class TestTask {

    @Test
    public void test01() throws ExecutionException, InterruptedException {
        ExecutorService executorService = Executors.newCachedThreadPool();
        Task task = new Task();
        Future<Integer> result = executorService.submit(task);
        //get方法阻塞当前线程，可重写get方法设置超时时间
        System.out.println(result.get());
    }

    class Task implements Callable<Integer> {

        @Override
        public Integer call() throws Exception {
            Thread.sleep(2000);
            return 2;
        }
    }

    class Task2 implements Callable<Integer> {

        @Override
        public Integer call() throws Exception {
            Thread.sleep(2000);
            return 5;
        }


    }
}
