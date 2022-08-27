package src.company;

/**
 * @author yudong
 */
public class OutTwo {
    private int a = 100;

    public class Inner {
        public void innerMethod() {
            System.out.println("outer a: " + a);
            /**
             * 引用外部类的方法
             * OutTwo.this.method
             * OutTwo.this.XXX 是在没有与外部类有重名的情况下
             *
             * 不可以定义静态变量和方法, final除外
             * 与外部类相连，不能独立使用
             *
             *
             *  public class Outer {
             *      private int a = 10;
             *      private void action() {
             *          System.out.println("action");
             *      }
             *      public void test() {
             *          Outer$Inner inner = new Outer$Inner(this);
             *          inner.innerMethod();
             *      }
             *
             *      static int access$0(Outer outer) {
             *          return outer.a;
             *      }
             *
             *      static void access$1(Outer outer) {
             *          outer.action();
             *      }
             *  }
             *
             *  public class Outer$Inner {
             *      final Outer outer;
             *      public Outer$Inner(Outer outer) {
             *          this.outer = outer;
             *      }
             *      public void innerMethod() {
             *          System.out.println("outer a " + Outer.access$0(outer));
             *          Outer.access$1(outer);
             *      }
             *  }
             *
             *  外部类返回接口，使用内部类实现接口
             *   
             * */
           // OutTwo.this.action();
            action();
            final int aa = 1;

        }
    }

    private void action() {
        System.out.println("action");
    }

    public void test() {
        Inner inner = new Inner();
        inner.innerMethod();
    }

    public static void main(String[] args) {
        OutTwo outTwo = new OutTwo();
        outTwo.action();

        System.out.println("Outer test方法----------");
        outTwo.test();

        System.out.println("成员内部类与外部类对象相连------------");
        OutTwo.Inner inner = outTwo.new Inner();
        inner.innerMethod();
    }
}
