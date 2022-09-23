package src.company.singleton;

public class LazyManUseVolatile {
    private static volatile LazyManUseVolatile instance;

    private LazyManUseVolatile() {
    }

    public static LazyManUseVolatile getInstance() {
        if (instance == null) {
            synchronized (LazyManUseVolatile.class) {
                if (instance == null) {
                    instance = new LazyManUseVolatile();
                }
            }
        }
        return instance;
    }

    public static void main(String[] args) {
        LazyManUseVolatile instance = getInstance();
        System.out.println(instance);
    }
}
