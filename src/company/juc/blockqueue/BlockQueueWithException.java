package src.company.juc.blockqueue;

import java.util.concurrent.ArrayBlockingQueue;

public class BlockQueueWithException {
    public static void main(String[] args) {
        ArrayBlockingQueue<String> blockingQueue = new ArrayBlockingQueue<>(3);
        System.out.println(blockingQueue.add("a"));
        System.out.println(blockingQueue.add("b"));
        System.out.println(blockingQueue.add("c"));
//        System.out.println(blockingQueue.add("d")); // Exception:Queue full
        System.out.println("========================");

        System.out.println(blockingQueue.remove());
        System.out.println(blockingQueue.remove());
        System.out.println(blockingQueue.remove());
//        System.out.println(blockingQueue.remove()); // exception: no element to remove

        // transient 不被序列化
        // 学习方法：直接对话，实践实践, 迭代
        // 交替学习，间隔休息
        // 走两步, 写笔记
        //
    }
}
