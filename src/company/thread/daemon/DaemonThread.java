package src.company.thread.daemon;

import java.util.concurrent.TimeUnit;

public class DaemonThread {
    public static void daemonThread() throws InterruptedException {
        int i = 0;
        while (true) {
            TimeUnit.SECONDS.sleep(1);
            i++;
            System.out.println("china: " + i);
        }
    }

    public static void main(String[] args) {
        Thread thread = new Thread(() -> {
            try {
                daemonThread();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        //守护线程，后台执行任务，自动退出
        thread.setDaemon(true);
        thread.start();
    }

}
