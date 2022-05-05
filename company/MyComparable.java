package company;

/**
 * @author yudong
 */
public interface MyComparable {

    /***
     * @param other
     * @return
     *
     * 接口方法不需要加修饰符，默认public abstract
     *
     * Java8之前接口内不能实现方法
     *
     * 接口可以定义变量，使用方法：MyComparable.a
     * 变量修饰符默认是public static final
     *
     * 接口可以继承，与类不同的是可以多继承
     *
     * public interface interface1{
     *  void method1();
     * },
     *
     * public interface interface2{
     *  void method2();
     * }
     *
     *
     * public interface interface3 extends interface1, interface2{
     *  void method3();
     * }
     *
     * public class Child extends Base implements interface3
     * {
     *    //method1,method2,method3都要实现
     *
     * }
     *
     * instanceof
     *
     * Point p = new Point(2,3)
     * if( p instance of MyComparable ) {
     *    return true;
     * }
     *
     * 组合可以复用代码，接口可统一处理不同类型的对象，二者结合，可替代继承
     *
     */

    int compareTo(Object other);

    public static final int a = 1;


}
