package src.company.thread;

public class ThreadState {

    public static void main(String[] args) throws InterruptedException {
        Thread thread = new Thread(() -> {
            for (int i = 0; i < 5; i++) {
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("thread run " + i);
            }
            System.out.println("////////");
        });

        Thread.State state = thread.getState();
        System.out.println(state);

        thread.start();

        while (state != Thread.State.TERMINATED) {
            Thread.sleep(100);
            state = thread.getState();
            System.out.println(state);
        }

//        thread.start(); 线程终止不能再次启动
    }

}
