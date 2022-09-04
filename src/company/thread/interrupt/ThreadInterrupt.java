package src.company.thread.interrupt;

import java.util.concurrent.TimeUnit;

public class ThreadInterrupt {
    public static void main(String[] args) throws InterruptedException {
        Thread thread = new Thread(() -> {
            try {
                TimeUnit.SECONDS.sleep(60);
            } catch (InterruptedException e) { //发生了中断
                System.out.println("oh I am interrupted");
            }
        });
        thread.start();
        TimeUnit.MILLISECONDS.sleep(2);
        thread.interrupt();
    }
}
