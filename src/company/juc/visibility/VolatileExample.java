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

        Switcher switcher = new Switcher();
        int num = 3;
        Thread[] threads = new Thread[num];
        for (int i = 0; i < 2; i++) {
            threads[i] = new Thread(() -> {
                for (int i1 = 0; i1 < 2; i1++) {
                    switcher.setOn(true);
                }
            });
            threads[i].start();
        }
        threads[2] = new Thread(()->{switcher.setOn(false);});
        threads[2].start();

        System.out.println(switcher.isOn());
    }
}
// 只是设置值，与前一个值无关，无竞态条件，但有可见性问题，所以使用volatile解决
class Switcher {
    private volatile boolean on;

    public boolean isOn() {
        return on;
    }

    public void setOn(boolean on) {
        this.on = on;
    }
}