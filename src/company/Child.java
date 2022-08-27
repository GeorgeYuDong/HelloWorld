package src.company;

/**
 * @author yudong
 */
public class Child extends Base {
    @Override
    public int getA() {
        return a;
    }

    private int a;

    /**
     * 子类通过super调用父类构造方法
     * 如果没有通过super调用,则自动调用父类默认构造方法
     * 如果父类没有默认构造方法，则子类必须通过super调用父类带参数的构造方法
     */
    public Child(String member) {
        super(member);
        System.out.println("基类构造方法，a: " + a);
        a = 7;
    }

    /**
     * 与父类同名的静态变量，静态方法，实例变量
     */
    public static String s = "child_base";
    public String m = "child";

    public static void staticTest() {
        System.out.println("child static: " + s);
    }

    public long sum(int a, long b) {
        System.out.println("child_int_long");
        return a + b;
    }

    /**
     * 父类构造方法应该只调用private方法，
     * 不要调用可被子类重写的方法(public,protected)，是一种不好的实践
     * 子类可以重写(override)父类非private方法,调用时，会动态绑定，执行子类方法
     * 无我，无世界，一切都是运动
     * 时间有限，空间有限，都是假象，只有运动才是永恒的
     */

    @Override
    protected void step1() {
        System.out.println("child step " + this.currentStep);
    }

    @Override
    protected void step2() {
        System.out.println("child step " + this.currentStep);
    }

    /**
     * 子类重写父类方法，子类可见性不能降低，可以提高。
     * 即父类protected,则子类为protected,或者public
     * 原因为继承反映的是is-a关系，子类应支持父类所有对外的行为
     * 子类可以增加父类的行为
     * <p>
     * <p>
     * final:修饰类，方法，变量，不能被继承，重写，修改
     */

    public static void main(String[] args) {
        /**
         * public: 子类变量(实例，静态)与方法(静态)父类同名时，
         * 哪个类型访问的,则访问哪个类型，即静态绑定。
         * 静态绑定编译阶段即决定了。
         * private:只可在类内访问，同名互不干涉，各自访问各自的。
         * 在子类内部访问时，即子类内部方法访问时，访问的是子类，
         * 子类有两份方法和变量，但内部访问时，隐藏了父类。
         *
         * 实例变量，静态变量，静态方法，private方法，都是静态绑定的
         * */
        Child child = new Child("abc");
        Base base = child;

        /**public方法是动态绑定的*/
        System.out.println("------base action");
        base.action();
        System.out.println("--------end action");

        /**
         * 动态绑定，base.a=7
         * 静态类初始化，只有一份
         *
         * */
        System.out.println("base.a: " + base.getA());
        System.out.println("child.a: " + child.getA());
        System.out.println(base.s);
        System.out.println(base.m);
        base.staticTest();

        System.out.println(child.s);
        System.out.println(child.m);
        /**
         * 通过实例对象也可访问静态方法
         * */
        child.staticTest();

        /**
         * protected 子类可见，包可见
         * 模板方法(使用protected的常见场景)：
         * child step 1
         * child step 2
         * */
        System.out.println("---------child action start");
        child.action();
        System.out.println("---------child action end");

        int a = 2;
        int b = 3;
        /**
         * 有多个重名函数,调用的时候，根据参数类型寻找所有重载版本中最匹配的，
         * 然后才匹配对应的类型，即引用变量的动态绑定。
         *
         * 子类对象可赋值给父类，向上转型，不会发生错误
         * 反之，向下转型，则可能会失败
         * */
        child.sum(a, b);

        Base base1 = new Child("GR");
        Child child1 = (Child) base1;

        /**
         * Base base2 = new Base("AB");
         * Child child2 = (Child)base2;
         * 编译成功，运行失败
         * 父类转换成子类，要看父类引用变量的动态类型,是不是这个子类，或子类的子类.
         * 能不能成功安全的类型转换，使用instanceof 关键字即可
         */
        System.out.println(base1 instanceof Child);

    }

}
