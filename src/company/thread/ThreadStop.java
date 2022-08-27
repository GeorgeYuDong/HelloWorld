package src.company.thread;

public class ThreadStop implements Runnable {

    boolean flag = true;

    @Override
    public void run() {
       int i = 0;
       while (flag) {
           System.out.println("run thread, " + i++);
       }
    }

    public void setStopFlag() {
        this.flag = false;
    }

    public static void main(String[] args) {
        ThreadStop threadStop = new ThreadStop();
        new Thread(threadStop, "abc").start();

        for (int i = 0; i < 1000; i++) {
            System.out.println(i + ", " + "main thread");
            if (i == 900) {
                //设置标志位停线程
                threadStop.setStopFlag();
            }
        }
    }
}
