package company;

/**
 * @author yudong
 */
public class ChapterFive {

    public static void main(String[] args) {
        /**
         * pointTwo是MyComparable类型的变量,引用了对象PointTwo对象
         * PointTwo实现了接口MyComparable
         * */
        MyComparable pointTwo = new PointTwo(1, 0);
        MyComparable pointTwo1 = new PointTwo(2, 0);
        int dd = pointTwo.compareTo(pointTwo1);
        System.out.println(dd);

        /**
         * 面向接口编程：
         * 依赖的是接口，而非实现接口的类型
         * 类型可以根据具体情况替换接口实现
         *
         * 而对对象的操作，变成了对接口操作，而不是具体的对象类型，
         * 实现了代码复用。
         *
         * 接口即规范，规范对接的是实现它的类型。
         * 规范是统一的入口,规范是变量名，对象是具体实例。
         *
         * 使用接口的方法：
         * 依赖的接口本身，而非接口的实现。降低了耦合，提高了灵活性。
         *
         * 抽象类，抽象方法，只有接口，没有实现
         * public abstract class Shape{
         *     public abstract void draw();
         *     定义了抽象方法的类一定要被声明为抽象类
         * }
         *
         * 抽象类可以有具体方法，实例变量，但不能new 对象，不能有实例
         *
         * 子类继承抽象类后，必须实现抽象类中定义的所有抽象方法
         *
         * 抽象类可引用子类创建的对象,即Shape shape = new Circle();
         * shape.draw();这是可以的
         *
         * 抽象类的作用：空方法体必须重写，使用抽象类，必须创建子类对象。
         *
         * 抽象类与接口配合使用：
         * 接口没有实例变量，抽象类有
         * 接口声明能力，抽象类提供默认实现，实现全部或部分方法
         * 一个接口，经常有一个对应抽象类
         * List接口，AbstractList抽象类
         *
         * 对具体类：可以选择实现接口，或者继承抽象类根据需要重写方法。
         * 如果具体类已经有父类，则只能自己全部实现接口方法（不能多继承）。
         *
         * public abstract class AbstractAdder implements IAdd {
         *      @override
         *      public void addAll(int[] numbers){
         *          for(int num : numbers) {
         *              add(num);
         *          }
         *      }
         * }
         *
         * public class Base extends AbstractAdder {
         *      private static final int MAX_NUM = 1000;
         *      private int[] arr = new int[MAX_NUM];
         *      private int count;
         *      @override
         *      public void add(int number) {
         *              if(count < MAX_NUM) {
         *                  arr[count++] = number;
         *              }
         *      }
         * }
         *
         * 抽象类不是必须的，但能使程序更为清晰，减少误用
         * 接口定义能力，抽象类提供默认实现，方便子类实现接口
         *
         * 内部类可以访问外部类私有变量，可声明为private对外实现隐藏
         * 技术上，内部类对java虚拟机是一个独立的字节码文件,是一个编译时概念
         *
         *
         * */

        Size size = Size.SMALL;
        System.out.println(size.toString());
        System.out.println(size.name());

        System.out.println("枚举比较---------------");
        System.out.println(size == Size.LARGE);
        System.out.println(size.equals(Size.SMALL));
        System.out.println(size == Size.SMALL);

        System.out.println("枚举下标-----------------");
        System.out.println(size.ordinal());
        System.out.println(Size.LARGE.ordinal());

        System.out.println("枚举比较CompareTo接口--------------------");
        System.out.println(size.compareTo(Size.MEDIUM));
        System.out.println(size.compareTo(Size.SMALL));

        /**
         * ENUM 可用于方法参数，类变量，实例变量
         * 可用于switch语句
         * */
        chose(size);

        System.out.println("valueOf方法------------------");
        System.out.println(Size.valueOf("LARGE"));
        System.out.println(Size.MEDIUM == Size.valueOf("MEDIUM"));

        System.out.println("values()方法----------------------");
        /**
         * values方法，Enum数组
         * */
        for (Size size1:
             Size.values()) {
            System.out.print(size1 + " ");
        }
        System.out.println("");

        System.out.println("从简写中得到枚举值,静态方法---------------------");
        System.out.println(Size.fromAbbr("M"));


    }

    /**
     * 枚举值在switch语句中转变为其ordinal()值
     *
     * */
    static void chose(Size size) {
        switch (size) {
            case LARGE:
                System.out.println("chose large");
                break;
            case SMALL:
                System.out.println("small");
                break;
            case MEDIUM:
                System.out.println("medium");
                break;
        }
    }
}





