package company.lambda;

public class LambdaTest {
    public static void main(String[] args) {
       MessagePrint p = ()->{
           System.out.println("china is the best");
       };
       p.printMessage();

       IChina china = (a, b)->{
           System.out.println(a + " love china " + b);
       };
       china.love("yudong", ", china is the best");

    }
}

interface MessagePrint {
    void printMessage();
}

interface IChina {
    void love(String a, String b);
}