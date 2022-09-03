package src.company.thread;

import lombok.SneakyThrows;

import java.util.concurrent.TimeUnit;

public class ThreadInherit extends Thread{
    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            System.out.println(i + ", " + "hello,world");
        }
    }

    public static void main(String[] args) throws InterruptedException {
        //1 and 2 两者交替执行
        new ThreadInherit().start(); //1

        for (int i = 0; i < 10; i++) { //2
            System.out.println( i + ", " + "www,china");
        }

        new ThreadInherit(){
            @Override
            public void run() {
                for (int i = 0; i < 10; i++) {
                    System.out.println(i + ", " + "https://baidu.com");
                }
            }
        }.start();

        new ThreadInherit(){
            @Override
            public void run() {
                for (int i = 0; i < 10; i++) {
                    System.out.println(i + ", " + "AWS");
                }
            }
        }.start();
    }
}
