package src.company;

/**
 * @author yudong
 */
public class Outer {
    private static int shared = 100;

    private static void hi() {
        System.out.println("hi");
    }

    /**
     * 静态内部类可以有静态变量，静态方法，成员方法，成员变量，构造方法
     * 可访问外部类的静态变量和方法，不可访问外部类的实例变量和方法
     */
    public static class StaticInner {
        public void innerMethod() {
            System.out.println("inner " + shared);
            hi();
        }
    }

    public void test() {
        StaticInner si = new StaticInner();
        si.innerMethod();
    }

    public static void main(String[] args) {
        /**
         * public class Outer {
         *      private static int shared = 100;
         *      public void test() {
         *          Outer$StaticInner si = new Outer$StaticInner();
         *          si.innerMethod();
         *      }
         *
         *      static int access$0() {
         *          return shared;
         *      }
         * }
         *
         * public class Outer$StaticInner {
         *     public void innerMethod() {
         *         System.out.println("inner: " + Outer.access$0());
         *     }
         * }
         * 与外部类关系密切，不依赖于外部类实例,使用静态内部类
         *
         * */
        Outer outer = new Outer();
        outer.test();

        StaticInner si = new StaticInner();
        si.innerMethod();
    }
}
