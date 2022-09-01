package src.company.juc.ProducerAndConsumer;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author george.yu
 * */
public class ConditionDemo {
    public static void main(String[] args) {
        /*
        List<Integer> list = Arrays.asList(1, 2, 3);
        list.forEach(System.out::println);
         */

    }
}

class DataUseCondition {

    Lock lock = new ReentrantLock();

}


