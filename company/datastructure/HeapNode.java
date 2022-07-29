package company.datastructure;

public class HeapNode {
    private int[] heap;
    private int size;

    public HeapNode(int capacity) {
        heap = new int[capacity];
    }

    //小顶堆建堆
    public void offer(int n) {
        int i = size;
        //用i来控制堆化结束, i = 0时，堆化结束
        while (i > 0) {
            int parent = (i - 1) >>> 1;
            // v为parent value
            int v = heap[parent];
            if (n >= v) {
                break;
            }
            //i = parent, heap[parent] = v;
            // n < v时，v结点移到index = i; 交换。
            heap[i] = v;
            i = parent; //parent实际上是新加入的元素能比较的次数
        }
        heap[i] = n;
        size++;
    }

    /**
     * 弹出堆顶元素，并删除，重新建堆
     */
    public int poll() {
        int top = heap[0];
        int[] newHeap = new int[size - 1];
        System.arraycopy(heap, 1, newHeap, 0, size - 1);
        heap = new int[heap.length];
        size = 0;
        for (int i : newHeap) {
            offer(i);
        }
        return top;
    }

    public int peek() {
        return heap[0];
    }

    public static void main(String[] args) {
        HeapNode heapNode = new HeapNode(6);
        System.out.println(heapNode.isEmpty());
        heapNode.offer(4);
        heapNode.offer(3);
        heapNode.offer(6);
        heapNode.offer(2);
        heapNode.offer(9);
        heapNode.offer(7);
        System.out.println(heapNode.peek());
        System.out.println(heapNode.poll());
        heapNode.offer(1);
        System.out.println(heapNode.peek());
    }

    public boolean isEmpty() {
        return size == 0 ? true : false;
    }
}
