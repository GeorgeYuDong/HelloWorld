package src.company.juc.visibility;


public class TestVisible {
    private long count = 0;

    public synchronized void add10K() {
        int idx = 0;
        while (idx++ < 1000000000) {
            count += 1;
        }
    }

    // getCount同样需要加锁，这样才能读到加完10K之后的变量, 锁的happens before原则
    public synchronized long getCount() {
        return count;
    }

    //20,0000,0000
    public static void main(String[] args) throws InterruptedException {
        TestVisible test = new TestVisible();
        // 创建两个线程，执行add()操作
        Thread th1 = new Thread(() -> {
            test.add10K();
        });
        Thread th2 = new Thread(() -> {
            long count = test.getCount();
            System.out.println("count is: " + count);
        });
        // 启动两个线程
        th1.start();
        th2.start();
        // 等待两个线程执行结束
        th1.join();
        th2.join();
        // 由于缓存，两个线程对象相加的结果达不到预期值，可见性问题待解决

        long count = test.getCount();
        System.out.println(count);
    }
}
