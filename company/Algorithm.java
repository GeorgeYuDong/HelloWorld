package company;

/**
 * @author yudong
 */
public class Algorithm {

    public static void main(String[] args) {
        int[] arr = {1, 2, 3};
        System.out.println(find(arr, 3, 3));
        System.out.println(find(arr, 3, 4));
    }
    //小规模数据排序，插入排序比快速排序快

    //cpu操作：读数据，运算，写数据
    //一切都是地址

    //O(1),O(logn),
    //O(nlogn),乘法法则，归并排序，快速排序
    //O(m+n),O(mn)
    //O(n2),n的平方

    //类方法,查找数组中某个值
    public static int find(int[] array, int n, int x) {
        for (int i = 0; i < n; i++) {
            if (x == array[i]) {
                return i;
            }
        }
        return -1;
    }
    //最好时间复杂度O(1),最坏时间复杂度O(n)
    //平均时间复杂度，加权平均值，O(n)
    //均摊时间复杂度，一组耗时多的操作，接下来是一组耗时少的操作，把时间均摊到耗时少的操作
    //均摊时间复杂度等于最好时间复杂度


}
