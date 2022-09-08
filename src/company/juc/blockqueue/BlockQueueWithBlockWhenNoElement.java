package src.company.juc.blockqueue;

import java.util.concurrent.ArrayBlockingQueue;

public class BlockQueueWithBlockWhenNoElement {
    public static void main(String[] args) throws InterruptedException {
        ArrayBlockingQueue<String> blockingQueue = new ArrayBlockingQueue<>(3);

        blockingQueue.put("a");
        blockingQueue.put("b");
        blockingQueue.put("c"); // put: try catch InterruptedException, put不了就一直等待
//        blockingQueue.put("d"); // 一直阻塞, 有可能被中断等待

        System.out.println("=======================");
        System.out.println(blockingQueue.take());
        System.out.println(blockingQueue.take());
        System.out.println(blockingQueue.take());
//        System.out.println(blockingQueue.take()); //没有元素了，一直阻塞
    }
}
