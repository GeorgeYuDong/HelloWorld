package company.datastructure;

public class HeapNode {
    private int[] heap;
    private int size;

    public HeapNode(int capacity) {
        heap = new int[capacity];
    }

    public void offer(int n) {
        int i = size;
        while (i > 0) {
            int parent = (i - 1) >>> 1;
            int v = heap[parent];
            if (n >= v) {
                break;
            }
            heap[i] = v;
            i = parent;
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
}
