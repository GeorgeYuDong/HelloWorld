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
     * <? extends E> 为E的子类,实例化类型参数，参数未知
     */
    public void allAll(DynamicArray<? extends E> c) {
        for (int i = 0; i < c.size; i++) {
            add(c.get(i));
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

    }
}
