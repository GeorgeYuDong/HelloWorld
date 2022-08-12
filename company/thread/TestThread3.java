package company.thread;

public class TestThread3 implements Runnable {
    //多线程不一定执行，依赖于操作系统调度
    @Override
    public void run(){
        for (int i = 0; i < 200; i++) {
            System.out.println(Thread.currentThread().getName() + " " +  i);
        }
    }

    public static void main(String[] args) {
        //实现runnable接口，创建实例对象
        var thread3 = new TestThread3();
        //实例对象作为入参给Thread,调用Thread.start()方法
        new Thread(thread3, "USA").start();
        new Thread(thread3, "CHINA").start();

        for (int i = 0; i < 1000; i++) {
            System.out.println("this is main method " + i);
        }
    }
}
