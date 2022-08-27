package src.company.thread;


public class ThreadYield {
   public static void main(String[] args) {

      new Thread(new MyYield(), "USA").start();
      new Thread(new MyYield(), "CHINA").start();
      new Thread(new MyYield(), "JAPAN").start();
   }
}

class MyYield implements Runnable {

   @Override
   public void run() {
      System.out.println(Thread.currentThread().getName() + " thread begin");
      //礼让不一定成功
      Thread.yield();
      System.out.println(Thread.currentThread().getName() + " thread end");
   }
}

