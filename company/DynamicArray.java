package company;

import java.util.Arrays;
import java.util.Random;

/**
 * @author yudong
 */
public class DynamicArray<E> {
    private static final int DEFAULT_CAPACITY = 10;
    private int size;
    private Object[] elementData;

    /**
     * elementData默认为10个元素的对象
     */
    public DynamicArray() {
        this.elementData = new Object[DEFAULT_CAPACITY];
    }

    /**
     * 参数：最小容量
     * 容量小于等于10个元素,直接返回
     * 否则, 新容量= 10 * 2
     * 如果新容量小于需要的容量,新容量等于需要的容量
     * <p>
     * 把10个元素赋值到新容量中
     */
    private void ensureCapacity(int minCapacity) {
        int oldCapacity = elementData.length;
        if (oldCapacity >= minCapacity) {
            return;
        }
        int newCapacity = oldCapacity * 2;
        if (newCapacity < minCapacity) {
            newCapacity = minCapacity;
        }
        elementData = Arrays.copyOf(elementData, newCapacity);
    }

    public void add(E e) {
        ensureCapacity(size + 1);
        elementData[size++] = e;
    }

    public E get(int index) {
        return (E) elementData[index];
    }

    public int size() {
        return size;
    }

    public E set(int index, E element) {
        E oldValue = get(index);
        elementData[index] = element;
        return oldValue;
    }

    /**
     * T的上界限定为E,类型为E
     * 第一种写法, T是一种声明
     * public <T extends E> void allAll(DynamicArray<T> c) {
     * 第二种写法如下
     * ? extends E 为E的子类,实例化类型参数，参数未知
     */
    public void allAll(DynamicArray<? extends E> c) {
        for (int i = 0; i < c.size; i++) {
            add(c.get(i));
        }
    }


    /**
     * 无限定通配符
     * 可以改为使用类型参数:
     * public static <T> int indexOf(DynamicArray<T> array, Object elem)
     * 通配符形式更为简洁
     * 两种通配符只能读，不能写
     */
    public static int indexOf(DynamicArray<?> array, Object elem) {
        for (int i = 0; i < array.size(); i++) {
            if (array.get(i).equals(elem)) {
                return i;
            }
        }
        return -1;
    }

    private static <T> void swapInternal(DynamicArray<T> array, int i, int j) {
        T tmp = array.get(i);
        array.set(i, array.get(j));
        array.set(j, tmp);
    }

    public static void swap(DynamicArray<?> array, int i, int j) {
        swapInternal(array, i, j);
    }

    /**
     * 参数之间有依赖关系，S是D的子类，只能用类型参数
     * 可以简化声明
     * static <D> void
     * copy(DynamicArray<D> dest, DynamicArray<? extends D> src)
     * */
    public static <D, S extends D> void copy(DynamicArray<D> dest,
                                             DynamicArray<S> src) {

        for (int i = 0; i < src.size(); i++) {
            dest.add(src.get(i));
        }
    }

    /**
     * ? super E 支持写入
     * */
    public void copyTo(DynamicArray<? super E> dest) {
        for (int i = 0; i < size ; i++) {
           dest.add(get(i));
        }
    }

    public static void main(String[] args) {
        DynamicArray<Double> array = new DynamicArray<>();
        Random rnd = new Random();
        int size = 1 + rnd.nextInt(100);
        for (int i = 0; i < size; i++) {
            array.add(Math.random());
        }
        Double d = array.get(rnd.nextInt(size));
        System.out.println(d);
        System.out.println(array.size());

        Integer[] arr = Arrays.copyOf(new Integer[]{1, 2, 3}, 40);
        System.out.println(arr.length);

        DynamicArray<Number> number = new DynamicArray<>();
        DynamicArray<Integer> ints = new DynamicArray<>();
        ints.add(100);
        ints.add(34);
        number.allAll(ints);
        ints.copyTo(number);

        System.out.println(indexOf(number, 34));
        System.out.println(indexOf(number, 100));

        DynamicArray<Integer> dynamicArray = new DynamicArray<>();
        DynamicArray<? extends Number> numberArray = dynamicArray;
        Integer a = 200;
        /**
         * ? extends Number 表示Number的子类型，无法确知是哪个类型。
         * 不能保证类型安全
         * */
        //  numberArray.add(a); 不能写入


    }
}
