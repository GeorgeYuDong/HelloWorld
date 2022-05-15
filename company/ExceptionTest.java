package company;

/**
 * @author yudong
 */
public class ExceptionTest {
    public static void main(String[] args) throws AppException {
        String s = "abc";
        System.out.println("end");
        //null,NullPointerException对象
        //启用异常默认处理机制，打印异常栈信息到屏幕
        //throw 异常退出
        System.out.println(s.indexOf("b"));

        System.out.println("exception-----------------");
        if (args.length < 1) {
            System.out.println("please input numbers: ");
            return;
        }

        try {
            int num = Integer.parseInt(args[0]);
            /**
             * 捕获到异常后，是相对于return的一种退出机制
             * 由系统触发，也可由throw触发
             * System.out.println(args[0])就不执行了
             *
             * catch 可由多个，需要说明的是，匹配到第一个合适的,后面的不再执行.
             * 若未匹配到，继续到上层方法中查找。
             *
             * 如果抛出的异常是catch的子类，也算匹配。所以catch需要将最具体的子类放在前面
             *
             * e.getMessage()获取异常消息
             * e.printStackTrace()打印异常栈到标准错误输出流
             *
             * */
            System.out.println(args[0]);
        } catch (NumberFormatException e) {
            System.out.println("param:" + args[0] + " is not number,please input number");
            //捕获后抛出新异常
            //e传入给AppException,形成异常链. 通过e.getCause()可得到NumberFormatException
            throw new AppException("输入不正确", e);
        } catch (RuntimeException e) {
            System.out.println("runtime exception: " + e.getMessage());
        } catch (Exception e) {
            System.out.println("exception:" + e.getCause());
            e.printStackTrace();
        } finally {
            /**
             * 不管有无异常都执行
             * 一般用于释放资源，如数据库连接，文件流等
             *
             * return 语句在finally执行后才执行,但finally不能改变返回值
             *
             * ret = 2
             * try{
             *     return ret;
             * }finally{
             *     ret = 0;
             * }
             * 返回值为2而不是0.
             *
             * 如果finally中有return,则try和catch中的return会丢失,
             * finally中的return会覆盖返回值，try和catch中的异常也会覆盖,
             * 就像异常没发生一样
             * */
        }

        /**
         * Throwable4个构造方法
         * public Throwable()
         * public Throwable(String message)
         * public Throwable(String message, Throwable cause)
         * public Throwable(Throwable cause)
         *
         * cause 触发该异常的其他异常，异常可以形成一个异常链,cause是底层异常
         * message 异常消息
         *
         * 设置cause
         * Throwable initCause(Throwable cause)
         *
         * Throwable子类，没有带cause参数的构造方法，可以通过这个方法来设置,
         * 该方法最多只能被调用一次.
         *
         * 构造方法内部有一句重要的函数调用fillInStackTrace()
         *
         * String getMessage() 获取设置的异常message
         * Throwable getCause() 获取异常cause
         * void printStackTrace() 打印异常栈信息到标准错误流
         *
         * finally中有异常，原异常会被覆盖
         *
         * finally中有return, try和catch中的返回值会被替代
         *
         * finally中有throw, try中的异常会被掩盖
         *
         * 避免在finally中return,或throw异常。若遇到异常，则捕获处理
         *
         * try-with-resources,try语句执行完后，自动调用close()方法
         * public static void useResource() throws Exception{
         *     try(AutoCloseable r = new FileInputStream("hello")){
         *
         *     }
         * }
         *
         * throws声明一个方法可能抛出的异常。调用者必须处理。针对受检异常必须进行声明,
         * 没有声明不能抛出。
         * 可以声明不实际抛出，父类可不抛出，子类实现抛出。
         *
         * 对一个方法调用另一个声明未受检异常的方法，必须处理，
         * 处理方法，可以catch，也可以向上继续使用throws, 由上层处理
         * public void tester() throws AppException{
         *     try{
         *         test();
         *     } catch(SQLException e){
         *         e.printStackTrace();
         *     }
         * }
         *
         * 异常在一个项目中，要按照约定处理
         *
         * 真正出现异常的时候，应该抛出异常，而不是返回特殊值
         * */
       // System.out.println("test() return value is " + test());
        test();
    }


    public static void test() {
        try {
            int a = 5 / 0;
          //  return 1;
        }
        /**
        catch (ArithmeticException e) {
 //           throw new AppException("hello");
            System.out.println("0不能作为被除数");
    //        return 4;
        } **/
         finally {
            throw new RuntimeException("hello");
//            return 3;
        }
    }

}
