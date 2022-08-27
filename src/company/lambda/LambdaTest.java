package src.company.lambda;

public class LambdaTest {
    public static void main(String[] args) {
        MessagePrint p = () -> {
            System.out.println("china is the best");
        };
        p.printMessage();

        // IChina接口的实现
        IChina china = (a, b) -> {
            System.out.println(a + " love china, " + b);
        };
        china.love("George", "china is the best country");

        Runnable runnable = () -> {
            for (int i = 0; i < 100; i++) {
                System.out.println(i + " " + "foreign language is the best weapon of struggle life");
            }
        };
        new Thread(runnable).start();

        runnable = () -> {
            for (int i = 0; i < 100; i++) {
                System.out.println(i + " " + "baidu");
            }
        };
        runnable.run();
    }

}

interface MessagePrint {
    void printMessage();
}

interface IChina {
    void love(String a, String b);
}