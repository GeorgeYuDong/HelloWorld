package src.company.juc.visibility;


public class TestVisible {
    private long count = 0;

    public void add10K() {
        int idx = 0;
        while (idx++ < 100000000) {
            count += 1;
        }
    }

    public static void main(String[] args) throws InterruptedException {
        TestVisible test = new TestVisible();
        // 创建两个线程，执行add()操作
        Thread th1 = new Thread(() -> {
            test.add10K();
        });
        Thread th2 = new Thread(() -> {
            test.add10K();
        });
        // 启动两个线程
        th1.start();
        th2.start();
        // 等待两个线程执行结束
        th1.join();
        th2.join();
        // 由于缓存，两个线程对象相加的结果达不到预期值，可见性问题待解决
        long count = test.count;
        System.out.println(count);
    }
}
