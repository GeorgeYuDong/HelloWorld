package src.company.juc.atomic;

import java.util.concurrent.atomic.AtomicInteger;

public class AtomicDemo {

    // volatile 内存屏障保证禁止指令重排序，同时八大规则保证可见性
    // 不能使用count++, 它是非原子操作。
    // 使用原子类，加volatile操作
    // 非阻塞操作，不上锁，重试
    private volatile static AtomicInteger num = new AtomicInteger(0);

    public static void add() {
        //获取旧值并加1
        num.getAndIncrement(); //原子操作
//        num.incrementAndGet();
    }

    public static void main(String[] args) throws InterruptedException {

        // initialValue = value, value is volatile, 保证可见性
        AtomicInteger atomicInteger = new AtomicInteger(2020);
        System.out.println(atomicInteger.compareAndSet(2020, 2021));
        System.out.println(atomicInteger.get());

//        int a = num.incrementAndGet(); //返回的是加了之后的值
//        int a = num.getAndIncrement(); //返回的是加了之前的值
//        System.out.println("a is: " + a); //对num而言，返回的都是加了之后的值

        System.out.println("Processors num is: " + Runtime.getRuntime().availableProcessors());
        // 自身文明的觉醒,进化
        // 十字军东征
        // 文明的冲突
        // 活着是最大的价值

        // volatile
        // 指令重排序
        // 可见性
        // 原子性

        Thread[] threads = new Thread[20];
        for (int i = 0; i < 20; i++) {
            threads[i] = new Thread(()->{
                for (int j = 0; j < 1000; j++) {
                    add();
                }
            });
        }

        for (int i = 0; i < 20; i++) {
           threads[i].start();
       //    threads[i].join();
        }

        //线程数大于2时，通知放弃cpu,一直等到线程结束。
        while (Thread.activeCount() > 2) {
            Thread.yield();
        }

        System.out.println("In " + Thread.currentThread().getName() + " thread, num is: " + num);

    }
}
