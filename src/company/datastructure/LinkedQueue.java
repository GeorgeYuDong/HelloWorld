package src.company.datastructure;

public class LinkedQueue<E> {

    private Node<E> tail;
    private Node<E> head;
    private int size;

    private static class Node<E> {
        E item;
        Node<E> next;
        public Node(E item, Node<E> next) {
            this.item = item;
            this.next = next;
        }
    }

    public LinkedQueue() {}

    public boolean enQueue(E element) {
        Node<E> newnode = new Node<>(element, null);
        if (tail == null) {
           tail = newnode;
           head = tail;
           return true;
        }
        tail.next = newnode; //单链表，当前指针的下一个结点为newnode,同时当前节点变更为新结点newnode
        tail = newnode;
        return true;
    }

    public E deQueue() {
        if (head == null) {
            throw new RuntimeException("Queue is empty");
        }
        E item = head.item;
        head = head.next;
        return item;
    }

    public static void main(String[] args) {
        LinkedQueue<String>  linkedQueue = new LinkedQueue<>();
        linkedQueue.enQueue("11");
        linkedQueue.enQueue("21");
        linkedQueue.enQueue("31");
        System.out.println("------------------------");
        System.out.println(linkedQueue.deQueue());
        linkedQueue.enQueue("41");
        System.out.println(linkedQueue.deQueue());
        System.out.println(linkedQueue.deQueue());
        System.out.println(linkedQueue.deQueue());
        System.out.println("------------------------");
    }
}
