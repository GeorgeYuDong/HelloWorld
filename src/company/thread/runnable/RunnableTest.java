package src.company.thread.runnable;

//public class RunnableTest implements Runnable {
public class RunnableTest {

    private int count;

    /*
    @Override
    public void run() {
//        System.out.println(Thread.currentThread().getName() + ", hello,world");
        for (int i = 0; i < 5; i++) {
            count++;
            System.out.println(Thread.currentThread().getName() + " num is " + count);
        }
    }
     */

    public static void main(String[] args) throws InterruptedException {
        //3个线程执行同一个runnable对象，对象逻辑count++是在已有值基础之上一直递增
        //而不会从count=0开始递增
        RunnableTest runnableTest = new RunnableTest();
        Thread a = new Thread(() -> {
            synchronized (runnableTest) {
                for (int i = 0; i < 1000000; i++) {
                    runnableTest.count++;
                    System.out.println(Thread.currentThread().getName() + " num is " + runnableTest.count);
                }
            }
        }, "A");
        a.start();
        Thread b = new Thread(() ->
        {
            synchronized (runnableTest) {
                for (int i = 0; i < 1000000; i++) {
                    runnableTest.count++;
                    System.out.println(Thread.currentThread().getName() + " num is " + runnableTest.count);
                }
            }
        }, "B");
        b.start();
        /*
        Thread c = new Thread(runnableTest, "C");
        c.start();

         */

        a.join();
        b.join();
//        c.join();


        System.out.println("main routine count is: " + runnableTest.count);


    }
}
