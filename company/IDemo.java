package company;

/**
 * @author yudong
 */
public interface IDemo {
    void hello();

    /**
     * java8 允许定义静态方法
     * java8 之前，接口不能定义静态方法，静态方法只能定义在类中
     * Java8 之后，静态方法可直接定义在接口中，静态方法可直接实现在接口中
     * */
    public static void test() {
        System.out.println("test");
    }

    /**
     * java8 允许定义默认方法,实现类可改变，也可不改变
     * 是函数式数据处理的需求，是为了便于给接口增加功能
     *
     * java9 多个静态或默认方法可以是private,方便复用代码
     * */
    default void hi(){
        System.out.println("hi");
    }

    private void common(){
        System.out.println("common");
    }

    default void commonA(){
        common();
    }

    default void commonB(){
        common();
    }
}
