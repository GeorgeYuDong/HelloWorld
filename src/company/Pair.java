package src.company;

/**
 * @author yudong
 * pair是一个泛型类,与普通类区别在于多了<U,V>
 * 泛型即类型参数化,之前是对象参数化
 *
 * 运行时：
 * 类本身是Object,具体化的时候，用强制类型转化代替
 */
public class Pair<U, V> {
    U first;
    V second;

    /**
     * 类内部引用成员变量，用点号
     *
     * */
    public Pair(U first, V second) {
        this.first = first;
        this.second = second;
    }

    public U getFirst() {
        return first;
    }

    public V getSecond() {
        return second;
    }

    public static void main(String[] args) {

        /**
         * 多个类型以逗号分割
         * pair类和它处理的类型是不绑定的
         * Java编译器，擦除类型参数，替换为object. 运行时不知道String,Integer
         * 类型安全和可读性
         * 省去强制类型转换，类型出错时编译时会提示,类型安全
         *
         * 最常见的用途是作为容器类
         */
        Pair<String, Integer> pair = new Pair<>("ABC", 100);
        String name = pair.getFirst();
        Integer id = pair.getSecond();

        System.out.println(pair.first);
        System.out.println(pair.second);

        System.out.println(name);
        System.out.println(id);

        System.out.println(indexOf(new Integer[]{1, 3, 4}, 4));
        System.out.println(indexOf(new String[]{"abc", "老妈", "huiJun"}, "huiJun"));

        System.out.println(pair.getFirst());

        /**
         * 泛型的具体类型要在运行的时候才知道
         * 需要反射,注解,并发
         * */
        System.out.println(makePair("China",123).getFirst());
        System.out.println(makePair("China",123).getSecond());

        System.out.println(Integer.toString(123) instanceof String);
    }

    /**
     * 方法泛型,与类是不是泛型无关
     * 返回index
     * valueOf(String),根据字符串,返回包装类对象
     * parseInt(String),根据字符串，返回基本类型
     * toString(true or 123),返回字符串表示
     */
    public static <T> int indexOf(T[] arr, T elem) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i].equals(elem)) {
                return i;
            }
        }
        return -1;
    }

    /**
     * makePair 返回Pair,U，V具体类型编译器可自动推断
     * 方法泛型 在返回值前加<U,V,W>等
     * U first, V second, W third
     * @Pair<U,V>
     * */
    public static <U, V> Pair<U, V> makePair(U first, V second) {
        Pair<U, V> pair = new Pair<>(first, second);
        return pair;
    }


}
