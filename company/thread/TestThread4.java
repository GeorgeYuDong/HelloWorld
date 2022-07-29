package company.thread;

public class TestThread4 implements Runnable {

    private int ticketNum = 10;

    @Override
    public void run() {
        while (true) {
            if (ticketNum <= 0) {
                break;
            }
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName() + "-->get " + ticketNum-- + " ticket");
        }
    }

    public static void main(String[] args) {
        var ticket = new TestThread4();

        new Thread(ticket, "Jack").start();
        new Thread(ticket, "Rose").start();
        new Thread(ticket, "Paul").start();
    }
}
