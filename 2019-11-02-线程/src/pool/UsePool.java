package pool;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class UsePool {
    public static void main(String[] args) {
        ExecutorService pool = Executors.newFixedThreadPool(2);
        pool.execute(new Runnable() {
            @Override
            public void run() {
                while (true) {
                    System.out.println("我是第一个线程");
                }
            }
        });
        pool.execute(new Runnable() {
            @Override
            public void run() {
                while (true) {
                    System.out.println("我是第二个线程");
                }
            }
        });
    }
}
