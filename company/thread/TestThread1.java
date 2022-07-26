package company.thread;

//创建线程方式，继承Thread, 重写run(), 调用start()执行
public class TestThread1 extends Thread {
    @Override
    public void run(){
        for (int i = 0; i < 200 ; i++) {
            System.out.println("this is thread method " + i);
        }
    }

    public static void main(String[] args) {
        //创建线程对象
        var thread = new TestThread1();
        //调用start()执行
        thread.start();

        //执行主线程方法
        for (int i = 0; i < 1000; i++) {
            System.out.println("this is main method " + i);
        }
    }
}
