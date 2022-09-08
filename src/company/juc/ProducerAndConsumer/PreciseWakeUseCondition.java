package src.company.juc.ProducerAndConsumer;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class PreciseWakeUseCondition {

    // 精准唤醒,精准通知
    public static void main(String[] args) {
        DataWithPreciseWake dataWithPreciseWake = new DataWithPreciseWake();

        new Thread(() -> {
            for (int i = 0; i < 1; i++) {
                try {
                    dataWithPreciseWake.printA();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }, "A").start();

        new Thread(() -> {
            for (int i = 0; i < 1; i++) {
                try {
                    dataWithPreciseWake.printB();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }, "B").start();

        new Thread(() -> {
            for (int i = 0; i < 1; i++) {
                try {
                    dataWithPreciseWake.printC();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }, "C").start();
    }
}

class DataWithPreciseWake {
    private Lock lock = new ReentrantLock();
    Condition conditionA = lock.newCondition();
    Condition conditionB = lock.newCondition();
    Condition conditionC = lock.newCondition();
    private int number = 1;

    public void printA() throws InterruptedException {
        lock.lock();

        try {
            while (number != 1) {
                conditionA.await();
            }
            number = 2;
            System.out.println(Thread.currentThread().getName() + "=>B");
            conditionB.signal();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }

    public void printB() throws InterruptedException {
        lock.lock();

        try {
            while (number != 2) {
                conditionB.await();
            }
            number = 3;
            System.out.println(Thread.currentThread().getName() + "=>C");
            conditionC.signal();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }

    public void printC() throws InterruptedException {
        lock.lock();

        try {
            while (number != 3) {
                conditionC.await();
            }
            number = 1;
            System.out.println(Thread.currentThread().getName() + "=>A");
            conditionA.signal();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }

}
