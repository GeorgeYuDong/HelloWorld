package src.company.thread;

public class ThreadSyn {
    public static void main(String[] args) {
        BuyTicket buyTicket = new BuyTicket();

        int num = 5;
        Thread[] threads = new Thread[num];
        for (int i = 0; i < num; i++) {
           threads[i] = new Thread(buyTicket);
           threads[i].start();
        }
    }
}

class BuyTicket implements Runnable {

    boolean flag = true;
    private Integer ticketNum = 10;

    @Override
    public void run() {
        while (flag) {
            try {
                buy();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    private synchronized void buy() throws InterruptedException {
        if (ticketNum <= 0) {
            flag = false;
            return;
        }
        Thread.sleep(1000);
        System.out.println(Thread.currentThread().getName() + " get the " + ticketNum-- + " ticket");
    }
}