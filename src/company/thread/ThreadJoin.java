package src.company.thread;

public class ThreadJoin implements Runnable{
    @Override
    public void run() {
        for (int i = 0; i < 1000; i++) {
            System.out.println("vip is coming, " + i);
        }
    }

    public static void main(String[] args) throws InterruptedException {
        ThreadJoin threadJoin = new ThreadJoin();
        Thread thread = new Thread(threadJoin);
        thread.start();

        for (int i = 0; i < 100; i++) {
           if (i == 30) {
               thread.join(); //插队，使主线程阻塞
           }
           System.out.println("main routine, " + i);
        }
    }
}
