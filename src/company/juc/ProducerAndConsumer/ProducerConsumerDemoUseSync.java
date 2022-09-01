package src.company.juc.ProducerAndConsumer;

public class ProducerConsumerDemoUseSync {

    public static void main(String[] args) {
        DataUseSync data = new DataUseSync();
        new Thread(() -> {
            for (int i = 0; i < 5; i++) {
                data.increment();
            }
        }, "A").start();

        new Thread(() -> {
            for (int i = 0; i < 5; i++) {
                data.decrement();
            }
        }, "B").start();

        new Thread(() -> {
            for (int i = 0; i < 5; i++) {
                data.increment();
            }
        }, "C").start();

        new Thread(() -> {
            for (int i = 0; i < 5; i++) {
                data.decrement();
            }
        }, "D").start();
    }

}

//线程虚假唤醒
class DataUseSync {
    private int number = 0;

    public synchronized void increment() {
        while (number != 0) {
            try {
                this.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        number++;
        System.out.println(Thread.currentThread().getName() + "=>" + number);
        notifyAll();
    }

    public synchronized void decrement() {
        while (number == 0) {
            try {
                this.wait(); //阻塞在wait这里，当被notifyAll时，
                // 需要再检查一下条件，符合再去进行下一步，防止虚假唤醒
                // 也就是wait必须要在while检查条件中
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        number--;
        System.out.println(Thread.currentThread().getName() + "=>" + number);
        notifyAll();
    }
}
