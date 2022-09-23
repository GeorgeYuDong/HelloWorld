package src.company.singleton;

public class LazyMan {
    private static LazyMan instance;

    private LazyMan() {
    }

    /**
     * 用到的时候才创建，而不是定义的时候就创建
     * 但是有线程安全问题
     * */
    public static LazyMan getInstance() {
        if (instance == null) {
           instance = new LazyMan();
        }
        return instance;
    }

    public static void main(String[] args) {
        LazyMan instance = getInstance();
        System.out.println(instance);
    }
}
