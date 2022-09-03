package src.company.thread;

public class CounterThread {
    /*
    Counter counter;
    public CounterThread(Counter counter) {
        this.counter = counter;
    }
     */

    /*
    @Override
    public void run() {
        for (int i = 0; i < 1000; i++) {
            counter.increase();
        }
    }
     */

    public static void main(String[] args) throws InterruptedException {
        int num = 1000;
        Counter counter = new Counter();
        Thread[] threads = new Thread[num];

        //threads[0],叫啥名字不重要，重要的是指向Thread就行了
        for (int i = 0; i < num; i++) {
            threads[i] = new Thread(() -> {
                for (int k = 0; k < 1000; k++) {
                    counter.increase();
                }
            }, String.valueOf(i));
            threads[i].start();
        }

        for (int i = 0; i < num; i++) {
            threads[i].join();
        }
        System.out.println(counter.getCount());
    }
}

// 内存可见性问题，在于多核cpu，取数据可能从各自寄存器和缓存，而不从内存取，各自不可见
// 用volatile, synchronized,显示锁同步
// 线程调度，切换也有成本，创建本身也有成本
class Counter {
    private int count;

    //count++是非原子操作, synchronized使原子操作
    public synchronized void increase() {
        count++;
    }

    public synchronized int getCount() {
        return count;
    }
}