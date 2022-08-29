package src.company.thread.group;

import java.util.stream.IntStream;

public class ThreadConstruction {

    private final static String PREFIX = "ALEX-";

    private static Thread createThead(final int intName) {
        return new Thread(
                () -> System.out.println(Thread.currentThread().getName()),
                PREFIX + intName);
    }

    public static void main(String[] args) {

        IntStream.range(0, 5).mapToObj(ThreadConstruction::createThead).forEach(Thread::start);


        Thread t1 = new Thread("t1");

        ThreadGroup group = new ThreadGroup("TestGroup");

        Thread t2 = new Thread(group, "t2");

        ThreadGroup mainThreadGroup = Thread.currentThread().getThreadGroup();
        System.out.println("main thread group is: " + mainThreadGroup.getName());

        System.out.println("t1 ThreadGroup equals main ThreadGroup: " + (mainThreadGroup == t1.getThreadGroup()));

        System.out.println("t2 ThreadGroup equals main ThreadGroup: " + (mainThreadGroup == t2.getThreadGroup()));

        System.out.println("t2 ThreadGroup equals TestGroup: " + (t2.getThreadGroup() == group));

        int i = Integer.parseInt("123");
        System.out.println(i);
/*
        Runnable runnable = new Runnable() {

            final int MAX = Integer.MAX_VALUE;

            @Override
            public void run() {
                int i = 0;
                recurse(i);
            }

            private void recurse(int i) {
                System.out.println(i);
                if (i < MAX) {
                    recurse(i + 1);
                }
            }
        };

        Thread thread = new Thread(group, runnable, "Test", Integer.parseInt(args[0]));
        thread.start();

 */
    }
}
