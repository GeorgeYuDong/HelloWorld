package company;

/**
 * @author yudong
 */
public class LinkedListAlgo {
    public static class Node {
        private int data;
        private Node next;

        public Node(int data, Node next) {
            this.data = data;
            this.next = next;
        }

        public int getData() {
            return data;
        }

        public static void main(String[] args) {
           Node p1 = createNode(1);
           Node p2 = createNode(2);
           Node p3 = createNode(3);
           Node p4 = createNode(4);
           p1.next = p2;
           p2.next = p3;
           p3.next = p4;

           printAll(p1);

           Node pReverse = reverse(p1);
           System.out.println("after reverse");
           printAll(pReverse);
        }
    }

    public static Node createNode(int value) {
        return new Node(value, null);
    }

    public static void printAll(Node list) {
        Node p = list;
        while (p != null) {
            System.out.print(p.data + " ");
            p = p.next;
        }
        System.out.println("");
    }

    /**
     * 单链表翻转
     * */
    public static Node reverse(Node list) {
        Node curr = list, pre = null;
        while (curr != null) {
            Node next = curr.next;
            curr.next = pre;
            pre = curr;
            curr = next;
        }
        return pre;
    }
}
