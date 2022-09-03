package src.company.thread;

public class TestThreadStatic {
    //多线程不一定执行，依赖于操作系统调度
    public static void main(String[] args) throws InterruptedException {
        int num = 30;
        Thread[] threads = new Thread[num];
        for (int i = 0; i < 20; i++) {
            threads[i] = new Thread(() -> {
                for (int k = 0; k < 200; k++) {
                    StaticCounter.incr();
                }

                for (int i1 = 0; i1 < 10; i1++) {
                   StaticCounter.decr();
                }
            }
            );
            threads[i].start();
            threads[i].join(); //必须加join，等待全部线程执行完毕，主线程再去输出数值
        }
        System.out.println(StaticCounter.getCount());


    }
}

class StaticCounter {
    private static int count;

    public static synchronized void incr() {
        count++;
    }

    public static synchronized void decr() {
        count--;
    }

    public static synchronized int getCount() {
        return count;
    }
}
