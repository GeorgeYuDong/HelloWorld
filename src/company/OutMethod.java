package src.company;

/**
 * @author yudong
 */
public class OutMethod {
    private int a = 100;
    private static final String nation = "china";

    private static void hi() {
        System.out.println("hi");
    }

    /**
     * 方法内部类只能在定义的方法内使用
     * 如果是实例方法，则内部类可访问外部类的实例变量和方法，静态变量和方法
     * 实例变量和方法必须声明为final
     * 如果是静态方法，则内部类只能访问外部类的静态变量和静态方法
     *
     *
     *
     * */
    public static void test(final int param) {
        final String str = "hello";
        class Inner {
            public void innerMethod() {
                System.out.println("param: " + param);
                System.out.println("local var: " + str);
                System.out.println("nation: " + nation);
                hi();
            }
        }
        Inner inner = new Inner();
        inner.innerMethod();
    }

    public void method() {
        class Inner {
            public void innerMethod() {
                System.out.println("hello,world");
            }
        }
        Inner inner = new Inner();
        inner.innerMethod();
    }

    public static void main(String[] args) {
        test(25);
        OutMethod outMethod = new OutMethod();
        outMethod.method();
    }

    /**
     * 方法内部类内部实现
     * public class Outer {
     *     private int a = 100;
     *     public void test(final int param) {
     *          final String str = "hello";
     *          OuterInner  inner = new OuterInner(this,param);
     *          inner.innerMethod();
     *     }
     *     static int access$0(Outer outer) {
     *          return outer.a;
     *     }
     * }
     *
     * OuterInner类有一个实例变量outer指向外部对象,即Outer outer
     * 在构造方法中被初始化
     *
     * 对外部私有变量的访问通过access$0方法访问
     * 方法内部类对访问参数，通过在构造方法中传递参数实现
     *
     * 内部类操作的是自己的实例变量，并不是外部变量，所以外部的变量干脆设为final
     *
     * 如果需要修改外部变量，可传入数组，修改数组中的值
     * public class Outer {
     *     public void test() {
     *         final String[] str = String[]{"hello"};
     *         class Inner {
     *             public void innerMethod() {
     *                 str[0] = "hello,world";
     *             }
     *         }
     *         Inner inner = new Inner();
     *         inner.innerMethod();
     *         System.out.println(str[0]);
     *     }
     * }
     *
     * 方法内部类可以用成员内部类代替
     *
     *
     *
     *
     * public class OuterInner {
     *     Outer outer;
     *     int param;
     *     OuterInner(Outer outer, int param) {
     *         this.outer = outer;
     *         this.param = param;
     *     }
     *
     *     public void innerMethod() {
     *         System.out.println("Outer a " + Outer.access$0(this.outer));
     *         System.out.println("param " + param);
     *         System.out.println("local var " + "hello");
     *     }
     * }
     *
     *
     * */
}
