package src.company.thread.yield;

public class MyYield implements Runnable {

    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName() + " thread begin");
        //礼让不一定成功
        Thread.yield();
        System.out.println(Thread.currentThread().getName() + " thread end");
    }
}
