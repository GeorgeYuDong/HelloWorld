package src.company.thread;

public class Counter {
    private int count;
    //count++是非原子操作, synchronized使原子操作
    public synchronized void increase() {
        count++;
    }

    public synchronized int getCount() {
        return count;
    }
}
