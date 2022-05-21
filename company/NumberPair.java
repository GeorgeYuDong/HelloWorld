package company;

/**
 * @author yudong
 */
public class NumberPair<U extends Number, V extends Number> extends Pair<U, V> {
    /**
     * 类型参数的限定(类型限定为父类和其子类)
     */
    public NumberPair(U first, V second) {
        super(first, second);
    }

    public double sum() {
        return getFirst().doubleValue() + getSecond().doubleValue();
    }

    /**
     * 限定类型实现Comparable接口
     */
    public static <T extends Comparable<T>> T max(T[] arr) {
        T max = arr[0];
        for (int i = 1; i < arr.length; i++) {
            if (arr[i].compareTo(max) > 0) {
                max = arr[i];
            }
        }
        return max;
    }

    public static void main(String[] args) {
        /**
         * 限定类型后，类型不会擦除为Object,而是Number
         * 编译器会检查
         * */
        NumberPair<Integer, Double> pair = new NumberPair<>(10, 12.34);
        System.out.println(pair.sum());

        System.out.println(max(new Integer[]{1, 25, 3, 4}));
    }
}
