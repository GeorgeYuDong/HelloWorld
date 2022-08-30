package src.company.thread.yield;

import java.util.stream.IntStream;

public class TestYield {
    public static void main(String[] args) {
        //[range), 右边取不到
        IntStream.range(0, 2).mapToObj(TestYield::create).forEach(Thread::start);
    }

    private static Thread create(int index) {
        return new Thread(() ->
        {
            if (index == 0) {
                Thread.yield();
            }
            System.out.println(index);
        });
    }
}
