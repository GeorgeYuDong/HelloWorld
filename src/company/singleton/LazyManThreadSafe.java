package src.company.singleton;

public class LazyManThreadSafe {
    private static LazyManThreadSafe instance;

    private LazyManThreadSafe() {
    }

    public static synchronized LazyManThreadSafe getInstance() {
        if (instance == null) {
            instance = new LazyManThreadSafe();
        }
        return instance;
    }

    public static void main(String[] args) {
        /**
         * 访问需要上锁，资源浪费
         * */
        LazyManThreadSafe instance = getInstance();
        System.out.println(instance);

    }
}
