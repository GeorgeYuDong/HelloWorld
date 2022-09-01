package src.company.juc.visibility;

public class VolatileExample {
    private int x = 0;

    private volatile boolean aBoolean = false;

    public void writer() {
        x = 42;
        aBoolean = true;
    }

    public void reader() {
        if (aBoolean == true) {
            System.out.println(x);
        }
    }

    public static void main(String[] args) {
        VolatileExample example = new VolatileExample();
        Thread a = new Thread(() ->
        {
            example.x = 42;
            example.aBoolean = true;
            System.out.println(Thread.currentThread().getName());
        }, "a");
        Thread b = new Thread(() ->
        {
            if (example.aBoolean == true) {
                System.out.println(example.x);
            }
        }, "b");
        a.start();
        b.start();
    }
}
