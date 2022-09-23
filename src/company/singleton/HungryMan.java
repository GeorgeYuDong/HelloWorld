package src.company.singleton;

// 饿汉式模式 类加载的时候完成实例化，不会有线程安全问题
public class HungryMan {
    private static HungryMan instance = new HungryMan();

    private HungryMan() {
    }

    public static HungryMan getInstance() {
        return instance;
    }

    public static void main(String[] args) {
        /**
         * 饥不择食，定义的时候直接初始化
         * */
        HungryMan instance = getInstance();
        System.out.println(instance);
    }
}
