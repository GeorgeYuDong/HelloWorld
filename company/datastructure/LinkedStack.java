package company.datastructure;

public class LinkedStack<E> {

    public static class Node<E> {
        E item;
        Node<E> next;

        public Node(E item, Node<E> next) {
            this.item = item;
            this.next = next;
        }
    }

    private Node<E> header;
    private int elementCount;

    /**
     * header头指针不断变化，头指针即栈顶节点
     */
    public boolean push(E element) {
        header = new Node<>(element, header);
        elementCount++;
        return true;
    }

    public E pop() {
        if (header == null) {
            throw new RuntimeException("stack is empty");
        }
        E item = header.item;
        header = header.next;
        elementCount--;
        return item;
    }

    public E peek() {
        if (header == null) {
            throw new RuntimeException("stack is empty");
        }
        E item = header.item;
        return item;
    }

    public static void main(String[] args) {
        LinkedStack<String> linkedStack = new LinkedStack<>();
        linkedStack.push("11");
        linkedStack.push("21");
        linkedStack.push("31");

        System.out.println("------------------");
        String pop = linkedStack.pop();
        System.out.println("pop:" + pop);
        String peek = linkedStack.peek();
        System.out.println("peek:" + peek);
    }

}

