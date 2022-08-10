package company.thread;

public class RunableThread implements Runnable {

    @Override
    public void run() {
        for (int i = 0; i < 1000; i++) {
            System.out.println(i + ", " + "hello, world");
        }
    }

    public static void main(String[] args) {
        new Thread(new RunableThread()).start();

        //new Runnable()->new 接口(){}即匿名内部类
        new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 1000; i++) {
                    System.out.println(i + ", " + "AWS");
                }
            }
        }).start();

        for (int i = 0; i < 1000; i++) {
            System.out.println(i + ", " + "www.baidu.com");
        }

        //
        new Thread(() -> {
            for (int i = 0; i < 2000; i++) {
                System.out.println(i + ", " + "USA");
            }
        }).start();
    }
}