package src.company.datastructure;

import java.util.Arrays;
import java.util.Iterator;

public class MsArrayList<E> implements Iterable<E> {
    private static final int DEFAULT_CAPACITY = 3;
    private Object[] elementData;

    private int size;

    public MsArrayList() {
        elementData = new Object[DEFAULT_CAPACITY];
    }

    @Override
    public Iterator<E> iterator() {
        return new MsIterator();
    }

    public E get(int index) {
        return (E) elementData[index];
    }

    public E set(int index, E element) {
        int size = elementData.length;
        if (index > size - 1) {
            throw new IndexOutOfBoundsException();
        }
        E oldElement = (E) elementData[index];
        elementData[index] = element;
        return oldElement;
    }


    private void ensureCapacity(int capacity) {
        int oldCapacity = elementData.length;
        if (capacity >= oldCapacity) {
            int newCapacity = elementData.length * 2;
            elementData = Arrays.copyOf(elementData, newCapacity);
        } else {
            return;
        }
    }


    public void add(E element) {
        ensureCapacity(size + 1);
        elementData[size++] = element;
        return;
    }

    public int size() {
        return size;
    }

    class MsIterator implements Iterator<E> {
        int index = 0;

        @Override
        public boolean hasNext() {
            return index != elementData.length;
        }

        @Override
        public E next() {
            return (E) elementData[index++];
        }
    }

    /*
    * 数组适合读多的场景，可随机读取,不适合写多
    * */
    public static void main(String[] args) {
        MsArrayList<String> msArrayList = new MsArrayList<>();
        msArrayList.add("china");
        msArrayList.add("japan");
        msArrayList.add("USA");
        msArrayList.add("RUSSIA");

        msArrayList.forEach(s -> {
            System.out.println(s);
        });
        System.out.println(msArrayList.size());
        System.out.println(msArrayList.elementData.length);
    }
}
