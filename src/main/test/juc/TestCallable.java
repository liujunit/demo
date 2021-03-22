package juc;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

/**
 * 实现Callable接口 获取结果的时候主线程会等待结果线程结束后才进行执行
 */
public class TestCallable {

    public static void main(String[] args) {
        CallableDemo callableDemo = new CallableDemo();
        FutureTask<Integer> result = new FutureTask<>(callableDemo);
        new Thread(result).start();
        try {
            System.out.println("start-------------");
            Integer integer = result.get();
            System.out.println(integer);
            System.out.println("end--------------");
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
    }

}

class CallableDemo implements Callable<Integer> {

    @Override
    public Integer call() throws Exception {
        int sum = 0;
        for (int i = 0; i <= 100; i++) {
            sum  = sum + i;
            System.out.println(i);
        }
        return sum;
    }
}