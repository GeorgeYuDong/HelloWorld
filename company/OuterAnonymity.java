package company;

/**
 * @author yudong
 */
public class OuterAnonymity {
    public void test (final int x, final int y) {
        PointTwo pointTwo = new PointTwo(2,3){
            @Override
            public double distance(PointTwo pointTwo1){
               return x*x+y*y;
            }
        };
        System.out.println(pointTwo.distance(pointTwo));
    }

    /**
     * 匿名内部类只能被使用一次，用来创建一个对象
     * 父类是PointTwo,给父类构造方法传递了参数2，3
     * 重写了distance()
     *
     * 可定义实例变量和方法，可以有初始化代码块
     * 没有名字，没有构造方法, 自己无法接收参数
     * 可以根据参数列表，调用对应的父类构造方法
     * 可访问外部类的所有变量和方法
     * 可访问方法中的final参数和局部变量
     *
     * public class Outer {
     *     public void test(final int x, final int y) {
     *          Point p = new Outer$1(this,2,3,x,y);
     *          System.out.println(p.distance());
     *     }
     * }
     *
     * public class Outer$1 extends Point {
     *     int x2;
     *     int y2;
     *     Outer outer;
     *     Outer$1(Outer outer, int x1, int y1, int x2, int y2) {
     *        super(x1,y1);
     *        this.outer = outer;
     *        this.x2 = x2;
     *        this.y2 = y2;
     *     }
     *     @Override
     *     public double distance() {
     *         return distance(new Point(this.x2,this.y2));
     *     }
     * }
     *
     * 匿名内部类不需要做的，方法内部类也能做，但如果对象只创建一次，且不需要构造方法来
     * 接收参数，使用匿名内部类更简洁。
     *
     * 匿名内部类是实现回调的简便方式
     *
     * 将程序分为保持不变的主体框架，和针对具体情况的可变逻辑，通过回调的方式进行协作，
     * 是计算机程序的一种常用实践
     *
     * */
    public static void main(String[] args) {
        OuterAnonymity outerAnonymity = new OuterAnonymity();
        outerAnonymity.test(4,3);

        OuterAnonymity outerAnonymity1 = new OuterAnonymity();
        outerAnonymity1.test(2,3);
    }
}
