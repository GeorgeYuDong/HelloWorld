package company;

import java.util.concurrent.TimeUnit;

/**
 * @author yudong
 * 继承Thread,实现线程
 */
public class HelloThread extends Thread {

    /**
     * java.lang.Thread表示线程
     * 重写了run方法
     * 没有参数，没有返回值，不能抛出受检异常
     */
    @Override
    public void run() {
        System.out.println("线程1111");
        System.out.println("thread name is " + Thread.currentThread().getName());
        System.out.println("thread id is " + Thread.currentThread().getId());
    }

    public static void main(String[] args) {

        Thread thread = new HelloThread();

        /**给线程起名字
         * 优先级映射到操作系统，可能是相同的优先级
         */
        thread.setName("first thread");
        thread.setPriority(3);
        System.out.println("thread priority is " + thread.getPriority());

        /**
         * 第一个线程
         * start表示启动线程,操作系统分配线程相关资源，单独的程序执行计数器和栈
         * 操作系统会把这个线程作为一个独立个体进行调度，分配时间片运行，
         * 运行的方法即run(),run方法类似于单线程中的main方法
         * */
        thread.start();

        /**
         * 第二个线程,使用匿名内部类实现run方法
         * */
        Thread thread1 = new Thread() {
            @Override
            public void run() {
                System.out.println("all,i love china");
            }
        };
        thread1.setName("second thread");
        thread1.setPriority(6);
        System.out.println("thread1 priority is " + thread1.getPriority());
        thread1.start();

        /**
         * 直接调用run方法，顺序执行，不会有新的线程产生，线程名为main,即主函数
         * */
        System.out.println("主线程--------------");
        thread.run();

        Thread thread2 = new Thread() {
            @Override
            public void run() {
                for(;;) {
                    System.out.println("线程3--------");
                    try {
                        TimeUnit.SECONDS.sleep(2);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println("hello,world");
                    System.out.println("thread3 name is " + Thread.currentThread().getName());
                }

            }
        };
        thread2.start();

        Thread thread3 = new Thread() {
            @Override
            public void run() {
                System.out.println("线程4-----------");
                System.out.println("Chinese Great Wall");
                for(;;) {
                    System.out.println("China is the greatest country");
                    try {
                        TimeUnit.SECONDS.sleep(1);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println("abcdsfsdffdfd");
                    System.out.println("thread4 name is " + Thread.currentThread().getName());
                }
            }
        };
        thread3.start();

    }

}
