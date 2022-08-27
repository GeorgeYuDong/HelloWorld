package src.company.thread;

import java.text.SimpleDateFormat;
import java.util.Date;

public class ThreadCountDown {

    public static void main(String[] args) throws InterruptedException {

        //thread.sleep()方法的作用：

        //1.倒计时
        //Thread.sleep()不会释放锁
        countDown();

        //2.显示当前时间
        while (true) {
            var startTime = new Date();
            try {
                System.out.println(new SimpleDateFormat("HH:mm:ss").format(startTime));
                Thread.sleep(1000);
                startTime = new Date();
            }catch (InterruptedException e){
                e.printStackTrace();
            }
        }
    }

    public static void countDown() {
        int num = 10;

        while (num >= 0) {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(num--);
        }
    }
}
