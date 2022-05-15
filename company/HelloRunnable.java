package company;

/**
 * @author yudong
 */
public class HelloRunnable implements Runnable {
    @Override
    public void run() {
        System.out.println("线程--------------");
        System.out.println(Thread.currentThread().getName());
        System.out.println(Thread.currentThread().getId());
        System.out.println("hello");
    }

    public static void main(String[] args) {
        /**
         * 使用接口，Thread构造方法参数，需要new (接口实例对象,HelloRunnable())
         * 也要调用start方法
         * */
        Thread thread = new Thread(new HelloRunnable());
        thread.start();

        Runnable runnable = new Runnable(){
            @Override
            public void run(){
                System.out.println("runnable 线程1------------");
                System.out.println("1234567890");
            }
        };
        Thread thread1 = new Thread(runnable);
        thread1.start();

        Runnable runnable1 = new Runnable() {
            @Override
            public void run() {
                System.out.println("runnable 线程2-------------");
                System.out.println("china is the greatest country");
            }
        };
        Thread thread2 = new Thread(runnable1);
        thread2.start();
    }
}
