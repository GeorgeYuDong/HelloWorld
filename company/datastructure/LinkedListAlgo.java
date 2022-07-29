package company.datastructure;

public class LinkedListAlgo {
    private static class Node {
        private int data;
        private Node next;

        public Node(int data, Node next) {
            this.data = data;
            this.next = next;
        }

        public int getData() {
            return data;
        }
    }

    public static Node createNode(int value) {
        return new Node(value, null);
    }

    //找中间节点
    public static Node findMiddleNode(Node list) {
        if (null == list) {
            return null;
        }

        //属性是一种持久量，或者说是有状态的量，是连续的变化的, 直到对象终止才终止
        //属性在对象存续期间一直存在，直到对象销毁才结束
        Node fast = list;
        Node slow = list;

        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }

        return slow;
    }

    //链表反转
    public static Node reverse(Node head) {
        Node curr = null;
        while (head != null) {
            //获取当前节点的后面一个节点
            Node next = head.next;
            //设置当前节点的next
            head.next = curr;
            //设置前一个节点, 到head为null时，curr就是最后一个
            curr = head;
            //设置后面一个节点
            head = next;
        }
        return curr;
    }

    public static void printAll(Node head) {
        while (head != null) {
            System.out.println(head.data + " ");
            head = head.next;
        }
        System.out.println();
    }

    static Node head;
    static Node tail;

    public static void addList(int data) {
        Node node = createNode(data);
        if (head == null) {
            head = node;
            tail = head;
        } else {
            tail.next = node;
            tail = node;
        }
    }

    public static void main(String[] args) {

        for (int i = 0; i < 9; i++) {
            addList((i + 1) * 10);
        }
        /*
        Node node1 = createNode(11);
        Node node2 = createNode(21);
        Node node3 = createNode(31);
        Node node4 = createNode(41);
        Node node5 = createNode(51);

        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;
        */

        printAll(head);

        Node reverse = reverse(head);

        printAll(reverse);

        Node node = findMiddleNode(reverse);
        System.out.println(node.getData());

        //623066 7031008390177
    }


}
