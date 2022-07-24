package company.datastructure;

import java.util.Arrays;

public class ArrayQueue<E> {
    private Object[] elementData;
    private int tail;
    private int head;

    public ArrayQueue(int capacity) {
        elementData = new Object[capacity];
    }

    /**
     * 入队
     * */
    public boolean enQueue(E element) {
        if (tail >= elementData.length) {
           elementData = Arrays.copyOf(elementData, elementData.length << 1);
           //把未出队的数据搬移到index=0位置，节省内存空间
           if (head != 0) {
               if (tail - head >= 0) {
                   System.arraycopy(elementData, head, elementData, 0, tail - head);
               }
               tail = tail - head;
               head = 0;
           }
        }
        elementData[tail++] = element;
        return true;
    }

    /**
     * 出队
     * */
    public E deQueue() {
        if (head == tail) {
            throw new RuntimeException("Queue is empty");
        }
        return (E) elementData[head++];
    }

    public static void main(String[] args) {
        ArrayQueue<String> arrayQueue = new ArrayQueue<>(3);
        arrayQueue.enQueue("11");
        arrayQueue.enQueue("21");
        arrayQueue.enQueue("31");
        System.out.println("-------------------------");
        System.out.println(arrayQueue.deQueue());
        arrayQueue.enQueue("41");
        System.out.println(arrayQueue.deQueue());
        System.out.println(arrayQueue.deQueue());
        System.out.println(arrayQueue.deQueue());
        System.out.println("-------------------------");
    }
}
