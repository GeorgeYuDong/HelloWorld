package company.datastructure;

public class LinkedListAlgo {
    private static class Node {
        private int data;
        private Node next;

        public Node(int data, Node next){
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
        Node fast = list;
        Node slow = list;

        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }

        return slow;
    }



}
