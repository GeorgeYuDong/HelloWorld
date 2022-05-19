package company;


import java.util.Arrays;

/**
 * @author yudong
 */
public class Algorithm {

    public static void main(String[] args) {
        int[] arr = {1, 2, 3};
        System.out.println(find(arr, 3));
        System.out.println(find(arr, 4));

        int[] arr1 = new int[]{1, 2, 3, 5, 16};
        System.out.println(binarySearch(arr1, 5));

        int[] arr2 = new int[]{2, 3, 4, 2, 2, 8};
        System.out.println(removeElement(arr2, 2));
        System.out.println(Arrays.toString(arr2));

    }
    //小规模数据排序，插入排序比快速排序快

    //cpu操作：读数据，运算，写数据
    //一切都是地址

    //O(1),O(logn),
    //O(nlogn),乘法法则，归并排序，快速排序
    //O(m+n),O(mn)
    //O(n2),n的平方

    /**
     * 类方法,查找数组中某个值
     * 只跟传入的参数有关，与自己本身无关
     */
    public static int find(int[] array, int x) {
        for (int i = 0; i < array.length; i++) {
            if (x == array[i]) {
                return i;
            }
        }
        return -1;
    }

    /**
     * 二分查找 O(logN)
     */
    public static int binarySearch(int[] array, int target) {
        int left = 0, right = array.length - 1;
        while (left <= right) {
            int middle = left + (right - left) / 2;
            if (array[middle] < target) {
                left = middle + 1;
            } else if (array[middle] > target) {
                right = middle - 1;
            } else if (array[middle] == target) {
                return middle;
            }
        }
        return -1;
    }

    //最好时间复杂度O(1),最坏时间复杂度O(n)
    //平均时间复杂度，加权平均值，O(n)
    //均摊时间复杂度，一组耗时多的操作，接下来是一组耗时少的操作，把时间均摊到耗时少的操作
    //均摊时间复杂度等于最好时间复杂度

    /**
     * array,多个重复元素移除，双指针法
     * 一个指针遍历，发现不等于value的值(遍历意图,单纯遍历是没有意义的)
     * 快慢指针的动画牢记在心
     * 慢指针记录与比较值不同的值，并记录下标,从零开始.
     * 大道至简。
     * 逐个比较，值一样，则指针往前移。
     * 或者另一种思路，逐个比较，值不一样，重头复制(移动了位置而已),
     * 下标为0开始,数字本身没变.不一样的才复制，slow是新长度。
     * 因为遍历是有序的，所以搬移也是有序的
     * <p>
     * 分解：
     */
    public static int removeElement(int[] array, int value) {
        int slowIndex = 0;
        for (int fastIndex = 0; fastIndex < array.length; fastIndex++) {
            if (value != array[fastIndex]) {
                array[slowIndex] = array[fastIndex];
                slowIndex++;
            }
        }
        return slowIndex;
    }


}
