package company.datastructure;

import java.util.Iterator;

public class MsLinkedList<E> implements Iterable<E> {

    private int size;
    private Node<E> first;
    private Node<E> last;

    //实现迭代器方法，以实现遍历
    @Override
    public Iterator<E> iterator() {
        return new MyIterator();
    }

    class MyIterator implements Iterator<E> {
        int index;

        @Override
        public boolean hasNext() {
            return index != size;
        }

        @Override
        public E next() {
            return get(index++);
        }
    }

    private E get(int index) {
        return node(index).item;
    }

    private static class Node<E> {
        E item;
        Node<E> prev;
        Node<E> next;

        Node(Node<E> prev, E item, Node<E> next) {
            this.item = item;
            this.next = next;
            this.prev = prev;
        }
    }

    public void addLast(E element) {
        final Node<E> l = last;
        Node<E> newNode = new Node<>(l, element, null);
        last = newNode;
        if (l == null) {
            first = newNode;
        } else {
            l.next = newNode;
        }
        size++;
    }

    public E set(int index, E element) {
        Node<E> x = node(index);
        E oldValue = x.item;
        x.item = element;
        return oldValue;
    }

    private Node<E> node(int index) {
        if (index < (size >> 1)) { //索引在前半部分，从头部开始查找
            Node<E> x = first;
            for (int i = 0; i < index; i++) {
                x = x.next;
            }
            return x;
        } else { //可以实现二分查找，索引在后半部分，则从尾部开始查找
            Node<E> x = last;
            for (int i = size - 1; i > index; i--) {
                x = x.prev;
            }
            return x;
        }
    }

    public static void main(String[] args) {
        MsLinkedList<String> msLinkedList = new MsLinkedList<>();
        msLinkedList.addLast("1");
        msLinkedList.addLast("2");
        msLinkedList.addLast("3");
        msLinkedList.addLast("4");
        msLinkedList.addLast("5");
        msLinkedList.addLast("6");
        msLinkedList.addLast("7");
        msLinkedList.set(2, "set");

        msLinkedList.forEach(s -> {
            System.out.println(s);
        });


        System.out.println("index = 6 is " + msLinkedList.get(6));

        int size = 0b111;
        System.out.println("size is " + size);
        int a = size >> 1;
        System.out.println("a is " + a);
    }

    /**
    private static void printName(){
       // static int a = 1; 局部变量不能为静态变量,且必须初始化
        int a = 1;
        System.out.println(a);
    }
     */



}
