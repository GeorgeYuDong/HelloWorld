package src.company.thread;

import java.util.stream.IntStream;

//创建线程方式，继承Thread, 重写run(), 调用start()执行
public class TestThread1 extends Thread {
    private int count;

    private final static String PREFIX = "ALEX-";

    private static Thread createThead(final int intName) {
        return new Thread(
                () -> System.out.println(Thread.currentThread().getName()),
                PREFIX + intName);
    }

    @Override
    public void run() {
        for (int i = 0; i < 5; i++) {
            count++;
            System.out.println(Thread.currentThread().getName() + " num is " + count);
        }
    }

    public static void main(String[] args) throws InterruptedException {
        // 创建线程对象, 继承thread, 重写run方法
        // count++执行单元，多个线程会重复执行，
        // 执行起点count=0,而不是在其他线程已执行基础之上
        var thread2 = new TestThread1();
        //调用start()执行
        thread2.start();
//        thread2.join();

        TestThread1 thread1 = new TestThread1();
        thread1.start();
//        thread1.join();

        TestThread1 thread3 = new TestThread1();
        thread3.start();
//        thread3.join();
        IntStream.range(0, 5).boxed().map(integer -> new Thread(() -> System.out.println(Thread.currentThread().getName()))).forEach(Thread::start);

        // final的使用价值
        Thread thead = createThead(1);

        // 运行之前可修改线程名称
        thead.setName("abc");
        System.out.println("thead state is " + thead.getState());
        thead.start();
        System.out.println("thead name is " + thead.getName());

    }
}
