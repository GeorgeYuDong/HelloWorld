package src.company.thread;

import lombok.SneakyThrows;

public class TestThreadUseLambda {

    @SneakyThrows
    public static void main(String[] args) {

        Thread a = new Thread(Data::print, "A");
        a.start();
        a.join(100);//join方法就是排队执行，等待100ms,让A执行结束。有异常，抛Interrupted

        Thread b = new Thread(Data::print, "B");
        b.start();
        b.join(100);

        Thread c = new Thread(Data::print, "C");
        c.start();
        c.join(100);

    }
}

/**
 *
 */
class Data {
    public static void print() {
        System.out.println("Thread name " + Thread.currentThread().getName() + " id is: " + Thread.currentThread().getId());
        System.out.println("Thread name " + Thread.currentThread().getName() + " priority is: " + Thread.currentThread().getPriority());
        System.out.println("Thread name " + Thread.currentThread().getName() + " is alive : " + Thread.currentThread().isAlive());
        System.out.println("Thread name " + Thread.currentThread().getName() + " is daemon : " + Thread.currentThread().isDaemon());
    }
}
