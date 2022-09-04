package src.company.juc.countdownlatch;

import java.util.concurrent.CountDownLatch;

public class CountDownLatchDemo {
    public static void main(String[] args) throws InterruptedException {
        //减法计数器
        CountDownLatch countDownLatch = new CountDownLatch(6);

        for (int i = 0; i < 6; i++) {
            new Thread(() -> {
                System.out.println(Thread.currentThread().getName() + " Go out");
                countDownLatch.countDown();
            }).start();
        }

        countDownLatch.await(); //等待减为0，主线程才执行
        System.out.println("close door");




    }

}
