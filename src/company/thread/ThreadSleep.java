package src.company.thread;

public class ThreadSleep implements Runnable {

    private int ticketNum = 100;

    @Override
    public void run() {
        while (true) {
            if (ticketNum <= 0) {
                break;
            }
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            System.out.println(Thread.currentThread().getName() + " get the--> " + ticketNum-- + " railway ticket");
        }
    }

    public static void main(String[] args) {
        ThreadSleep threadSleep = new ThreadSleep();
        new Thread(threadSleep, "Paul").start();
        new Thread(threadSleep, "Jack").start();
        new Thread(threadSleep, "James").start();
    }
}
