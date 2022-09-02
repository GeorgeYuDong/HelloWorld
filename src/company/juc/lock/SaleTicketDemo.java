package src.company.juc.lock;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class SaleTicketDemo {

    public static void main(String[] args) {

        Ticket ticket = new Ticket();
        new Thread(() -> {
            for (int i = 0; i < 20; i++) {
                ticket.sale();
            }
        }, "A").start();

        new Thread(() -> {
            for (int i = 0; i < 50; i++) {
                ticket.sale();
            }
        }, "B").start();

    }


}

// 面试常问：单例模式，排序算法，生产着与消费者，死锁
// 线程并发问题根源：
// 原子性（线程切换，发生在CPU指令执行完，而不是高级语言指令执行完）
// 可见性（多核缓存）
// 有序性（编译优化，指令重排序）
// cpu将缓存刷入内存的时机是不确定的，h除非调用cpu相关指令强刷
// synchronized发生任务切换，锁是不会释放的
// io操作是设备驱动干的事，cpu只管发命令，发完就干别的事

class Ticket {
    private int number = 30;

    //reentrantLock可以设置是否非公平锁,默认非公平锁
    Lock lock = new ReentrantLock();

    public void sale() {
        lock.lock();
        try {
            if (number > 0) {
                System.out.println(Thread.currentThread().getName() + "卖出了第" + (number--) + "张票");
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }
}
