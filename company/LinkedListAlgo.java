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
    }

    /**
     * 类加载时，静态内部类就已被加载
     * 所以静态方法,是可以访问静态类，用它创建实例的。
     *
     * https://docs.aws.amazon.com/index.html
     * */
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
     * 三个指针
     * 步骤：
     * 1.获取下一个节点 next = curr->next
     * 2.当前节点指向前驱结点curr->pre
     * 3.当前结点转变为前驱结点(赋值操作)，pre=curr
     * 4.下一个结点转变为当前结点，curr=next
     *
     * 当前结点为null时，pre结点为尾结点，返回pre结点，则翻转成功
     */
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
