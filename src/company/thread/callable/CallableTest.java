package src.company.thread.callable;

import java.util.Random;
import java.util.concurrent.*;

public class CallableTest {
    class Runner implements Callable<Integer> {
        public String name;
        @Override
        public Integer call() throws Exception {
            int result = 0;
            int speed = new Random().nextInt(100);
            for (int i = 1; i <= 10 ; i++) {
               result = i * speed;
            }
            return result;
        }
    }

    public void start() throws ExecutionException, InterruptedException {
        ExecutorService executorService = Executors.newFixedThreadPool(3);

        Runner runnerA = new Runner();
        runnerA.name = "A";

        Runner runnerB = new Runner();
        runnerB.name = "B";

        Runner runnerC = new Runner();
        runnerC.name = "C";

        Future<Integer> r1 = executorService.submit(runnerA);
        Future<Integer> r2 = executorService.submit(runnerB);
        Future<Integer> r3 = executorService.submit(runnerC);

        executorService.shutdown();
        System.out.println("r3 = " + r3.get());
        System.out.println("r1 = " + r1.get());
        System.out.println("r2 = " + r2.get());

    }

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        new CallableTest().start();

    }
}
