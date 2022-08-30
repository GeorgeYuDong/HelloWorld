package src.company.thread.yield;

public class ThreadYield {
   public static void main(String[] args) {
      MyYield myYield = new MyYield();

      new Thread(myYield, "USA").start();
      new Thread(myYield, "CHINA").start();
   }
}

