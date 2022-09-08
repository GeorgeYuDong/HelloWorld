package src.company.juc.blockqueue;

import java.util.concurrent.ArrayBlockingQueue;

public class BlockQueueWithNoException {
    public static void main(String[] args) {
        ArrayBlockingQueue<String> blockingQueue = new ArrayBlockingQueue<>(3);

        System.out.println(blockingQueue.offer("a")); // true
        System.out.println(blockingQueue.offer("b")); // true
        System.out.println(blockingQueue.offer("c")); // true
        System.out.println(blockingQueue.offer("d")); // false : no exception

        System.out.println("=============================");

        System.out.println(blockingQueue.poll()); // a
        System.out.println(blockingQueue.poll()); // b
        System.out.println(blockingQueue.poll()); // c
        System.out.println(blockingQueue.poll()); // null : no exception
    }
}
