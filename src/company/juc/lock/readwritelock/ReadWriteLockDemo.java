package src.company.juc.lock.readwritelock;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class ReadWriteLockDemo {
    public static void main(String[] args) {

        MyCacheLock myCacheLock = new MyCacheLock();

        for (int i = 0; i < 3; i++) {
            int temp = i;
            new Thread(()->myCacheLock.put(temp+"", temp+"")).start();
        }

        for (int i = 0; i < 3; i++) {
           int temp = i;
           new Thread(()->myCacheLock.get(temp+"")).start();
        }
    }
}
//写锁独占， 读锁非读占，可同时读
class MyCacheLock {
    private volatile Map<String, Object> map = new HashMap<>();

    private ReadWriteLock readWriteLock = new ReentrantReadWriteLock();

    public void put(String key, Object value) {
        readWriteLock.writeLock().lock();
        try {
            System.out.println(Thread.currentThread().getName() + " write " + value);
            map.put(key,value);
            System.out.println(Thread.currentThread().getName() + " write OK");
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            readWriteLock.writeLock().unlock();
        }
    }

    public void get(String key) {
        readWriteLock.readLock().lock();
        try {
            System.out.println(Thread.currentThread().getName() + " get " + key);
            System.out.println(Thread.currentThread().getName() + " get value is " + map.get(key));
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            readWriteLock.readLock().unlock();
        }
    }
}