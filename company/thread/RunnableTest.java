package company.thread;

public class RunnableTest implements Runnable{
    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName() + ", hello,world");
    }

    public static void main(String[] args) {
        RunnableTest runnableTest = new RunnableTest();
        new Thread(runnableTest, "Jack").start();
        new Thread(runnableTest, "Jackson").start();
        new Thread(runnableTest, "Jacky").start();

    }
}
