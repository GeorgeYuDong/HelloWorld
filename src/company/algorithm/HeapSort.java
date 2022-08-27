package src.company.algorithm;

public class HeapSort {

    private int[] array;   //数组，从小标1开始
    private int n;     //最大可存储个数
    private int count; //已存储元素个数

    public HeapSort(int capacity) {
        array = new int[capacity + 1];
        n = capacity;
        count = 0;
    }

    private static void buildHeap(int[] arr, int n) {
        for (int i = n / 2; i >= 1; --i) {
            heapify(arr, n, i);
        }
    }

    /***
     *
     * @param data
     * 从下往上堆化,数组子节点数据与父节点数据比较，交换
     */
    public void insert(int data) {
        if (count >= n) {
            return;
        }
        ++count;
        array[count] = data;

        int i = count;
        while (i / 2 > 0 && array[i] > array[i / 2]) { //自下往上堆化,大顶堆
            swap(array, i, i / 2);
            i = i / 2;
        }
    }

    public void removeMax() {
        if (count == 0) {
            return;
        }
        array[1] = array[count]; //把最后一个元素放到root,root元素没了
        --count;
        heapify(array, count, 1);
    }

    /**
     * @param arr       堆化数组
     * @param lastindex 最后堆元素下标
     * @param i         要堆化的元素下标
     *                  自上往下堆化, 数组父节点与子节点比较
     */
    private static void heapify(int[] arr, int lastindex, int i) {
        while (true) {
            int maxPos = i;
            if (i * 2 <= lastindex && arr[i] < arr[i * 2]) {
                maxPos = i * 2;
            }
            if (i * 2 + 1 <= lastindex && arr[maxPos] < arr[i * 2 + 1]) {
                maxPos = i * 2 + 1;
            }
            if (maxPos == i) {
                break;
            }
            swap(arr, i, maxPos);
            //交换之后，要继续交换的元素就是子结点
            i = maxPos;
        }
    }

    //O(logN)
    private static void swap(int[] array, int index1, int index2) {
        int temp = array[index1];
        array[index1] = array[index2];
        array[index2] = temp;
    }

    public void printAll() {
        for (int i = 1; i <= count; i++) {
            System.out.print(array[i] + " ");
        }
        System.out.println();
    }

    public void sort() {
        int k = count;
        while (k > 1) {
            swap(array, 1, k);
            --k;
            //从上往下堆化
            heapify(array, k, 1);
        }
    }

    public static void main(String[] args) {
        int[] array = new int[]{1, 2, 3};
        swap(array, 2, 1);
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i] + " ");
        }

        System.out.println();

        var heapSort = new HeapSort(6);
        heapSort.insert(10);
        heapSort.insert(14);
        heapSort.insert(24);
        heapSort.insert(5);
        heapSort.insert(54);
        heapSort.printAll();

        heapSort.removeMax();
        heapSort.printAll();

        System.out.println("---------------------");

        heapSort.sort();
        heapSort.printAll();





        var arr = new int[]{0, 1, 3, 18, 24, 34, 23};
        buildHeap(arr, 6);
        for (int i = 1; i <= 6; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();




    }
}
