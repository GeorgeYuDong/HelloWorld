package company.thread;

public class ThreadInerit extends Thread{
    @Override
    public void run() {
        for (int i = 0; i < 1000; i++) {
            System.out.println(i + ", " + "hello,world");
        }
    }

    public static void main(String[] args) {
        //1 and 2 两者交替执行
        new ThreadInerit().start(); //1

        for (int i = 0; i < 1000; i++) { //2
            System.out.println( i + ", " + "www,china");
        }

        new ThreadInerit(){
            @Override
            public void run() {
                for (int i = 0; i < 1000; i++) {
                    System.out.println(i + ", " + "https://baidu.com");
                }
            }
        }.start();

        new ThreadInerit(){
            @Override
            public void run() {
                for (int i = 0; i < 1000; i++) {
                    System.out.println(i + ", " + "AWS");
                }
            }
        }.start();
    }
}
