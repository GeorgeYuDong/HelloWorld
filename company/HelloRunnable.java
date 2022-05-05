package company;

/**
 * @author yudong
 */
public class HelloRunnable implements Runnable {
    @Override
    public void run() {
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


    }
}
