package src.company.thread;

import java.util.concurrent.TimeUnit;

public class TestThreadStatic {
    //多线程不一定执行，依赖于操作系统调度
    public static void main(String[] args) throws InterruptedException {
        int num = 3;
        Thread[] threads = new Thread[num];
        for (int i = 0; i < num; i++) {
            threads[i] = new Thread(() -> {
                for (int k = 0; k < 200; k++) {
                    StaticCounter.incr();
                }

                for (int i1 = 0; i1 < 10; i1++) {
                   StaticCounter.decr();
                }
            }
            );
            threads[i].start();
//            TimeUnit.SECONDS.sleep(1);
            threads[i].join(); //必须加join，等待全部线程执行完毕，主线程再去输出数值
            System.out.println(StaticCounter.getCount());
        }


    }
}

class StaticCounter {
    private static int count;

    // synchronized 可重入锁，记录锁的持有线程和数量实现
    // 非原子操作，产生竞态条件
    public static synchronized void incr() {
        count++;
    }

    public static synchronized void decr() {
        count--;
    }

    public static synchronized int getCount() {
        return count;
    }
}
