package src.company.juc;

import java.util.concurrent.CopyOnWriteArrayList;

public class CopyOnWriteListTest {
    public static void main(String[] args) {
        CopyOnWriteArrayList<String> copyOnWriteArrayList = new CopyOnWriteArrayList<String>();
        for (int i = 0; i < 1000; i++) {
           new Thread(()->{
               copyOnWriteArrayList.add(Thread.currentThread().getName());
           }).start();
        }

        try {
            Thread.sleep(300);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println(copyOnWriteArrayList.size());

        // 单例模式
        // 排序算法
        // 生产者与消费者
        // 死锁
    }
}
