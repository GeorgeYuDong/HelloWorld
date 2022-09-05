package src.company.juc.functioninterface;

import java.util.function.Consumer;

public class ConsumerInterfaceDemo {
    public static void main(String[] args) {
        Consumer<String> consumer = new Consumer<>() {
            @Override
            public void accept(String o) {
                System.out.println(o);
            }
        };
        consumer.accept("hello");


        // lambda 无返回值
        // 需要参数，消费产品
        Consumer<String> stringConsumer = str -> {
            System.out.println(str + " is the strongest!!");
        };
        stringConsumer.accept("china");
    }
}
