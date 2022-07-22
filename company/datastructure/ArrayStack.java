package company.datastructure;

import java.util.Arrays;

public class ArrayStack<E> {
    private Object[] elementData;
    private int topIndex;

    public ArrayStack(int capacity) {
        elementData = new Object[capacity];
    }

    /**
     * 入栈
     * @param element
     * @return
     */
    public boolean push(E element) {
        if (topIndex >= elementData.length) {
            int newCapacity = elementData.length << 1;
            elementData = Arrays.copyOf(elementData, newCapacity);
        }
        elementData[topIndex++] = element;
        return true;
    }

    /**
     * 出栈并且删除栈顶元素
     *
     * @return
     */
    public E pop() {
        if (topIndex <= 0) {
            throw new RuntimeException("栈为空");
        }
        return (E) elementData[--topIndex];
    }

    /**
     * 出栈
     * @return
     */
    public E peek() {
        if (topIndex <= 0) {
            throw new RuntimeException("栈为空");
        }
        return (E) elementData[topIndex - 1];
    }

    public int getTopIndex() {
        return topIndex;
    }

    public static void main(String[] args) {
        ArrayStack<String> arrayStack = new ArrayStack<>(10);
        arrayStack.push("11");
        arrayStack.push("21");
        arrayStack.push("31");

        System.out.println("push---------------------");
        System.out.println("topIndex is " + arrayStack.getTopIndex());

        System.out.println("pop");
        System.out.println(arrayStack.pop());
        System.out.println("first pop topIndex is " + arrayStack.getTopIndex());

        System.out.println(arrayStack.pop());
        System.out.println("second pop topIndex is " + arrayStack.getTopIndex());
        System.out.println("---------------");
        System.out.println("----peek----------");
        System.out.println(arrayStack.peek());
        System.out.println("first peek topIndex is " + arrayStack.getTopIndex());
    }




}
