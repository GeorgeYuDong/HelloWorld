package src.company.juc.lock;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class SaleTicketDemo {

    public static void main(String[] args) {

        Ticket ticket = new Ticket();
        new Thread(() -> {
            for (int i = 0; i < 10; i++) {
                ticket.sale();
            }
        }, "A").start();

        new Thread(() -> {
            for (int i = 0; i < 20; i++) {
                ticket.sale();
            }
        }, "B").start();

    }


}
//面试常问：单例模式，排序算法，生产着与消费者，死锁
class Ticket {
    private int number = 30;

    //reentrantLock可以设置是否非公平锁,默认非公平锁
    Lock lock = new ReentrantLock();

    public void sale() {
        lock.lock();
        try {
            System.out.println(Thread.currentThread().getName() + "卖出了第" + (number--) + "张票");
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }
}
