package company.algorithm;

import java.util.Arrays;
import java.util.Scanner;

public class BinarySearch {

    public static int binarySearch(int a[], int n, int value) {
        int low = 0, high = n - 1;

        while (low <= high) {
            //int mid = (low + high) / 2;
            //防止low + high 过大溢出
            int mid = low + ((high - low) >>> 1);
            if (value == a[mid]) {
                return mid;
            } else if (a[mid] < value) { //value is in the right of mid, low move to mid right location
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return -1;
    }

    /**
     * 二分查找指定元素，若有重复元素,则返回第一个下标位置
     */
    public static int bSearchFirstEquals(int a[], int n, int value) {
        int low = 0, high = n - 1;

        while (low <= high) {
            //int mid = (low + high) / 2;
            //防止low + high 过大溢出
            int mid = low + ((high - low) >>> 1);
            if (value < a[mid]) {
                high = mid - 1;
            } else if (a[mid] < value) { //value is in the right of mid, low move to mid right location
                low = mid + 1;
            } else {
                if (mid == 0 || a[mid - 1] != value) {
                    return mid;
                } else {
                    high = mid - 1;
                }
            }
        }
        return -1;
    }

    /**
     * 二分查找指定元素，若有重复元素,则返回最后一个下标位置
     */
    public static int bSearchLastEquals(int a[], int n, int value) {
        int low = 0, high = n - 1;

        while (low <= high) {
            //int mid = (low + high) / 2;
            //防止low + high 过大溢出
            int mid = low + ((high - low) >>> 1);
            if (value < a[mid]) {
                high = mid - 1;
            } else if (a[mid] < value) { //value is in the right of mid, low move to mid right location
                low = mid + 1;
            } else {
                if (mid == a.length - 1 || a[mid + 1] != value) {
                    return mid;
                } else {
                    low = mid + 1;
                }
            }
        }
        return -1;
    }

    /**
     * 二分查找大于等于指定元素，若有重复元素,则返回第一个下标位置
     */
    public static int bSearchFirstGreaterThan(int a[], int n, int value) {
        int low = 0, high = n - 1;

        while (low <= high) {
            //int mid = (low + high) / 2;
            //防止low + high 过大溢出
            int mid = low + ((high - low) >>> 1);
            if (a[mid] >= value) {
                if (mid == 0 || a[mid - 1] < value) {
                    return mid;
                } else {
                    //要找的值在[low, mid]之间，所以high要往前走
                    high = mid - 1;
                }
            } else if (a[mid] < value) { //value is in the right of mid, low move to mid right location
                low = mid + 1;
            }
        }
        return -1;
    }

    /**
     * 二分查找小于等于指定元素，若有重复元素,则返回最后一个下标位置
     */
    public static int bSearchLastLessThan(int a[], int n, int value) {
        int low = 0, high = n - 1;

        while (low <= high) {
            //int mid = (low + high) / 2;
            //防止low + high 过大溢出
            int mid = low + ((high - low) >>> 1);
            if (a[mid] <= value) {
                if (mid == n - 1 || a[mid + 1] > value) {
                    return mid;
                } else {
                    low = mid + 1;
                }
            } else if (a[mid] > value) { //value is in the right of mid, low move to mid right location
                high = mid - 1;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] a = {1, 2, 4, 5, 90, 120, 240};
        System.out.println(binarySearch(a, a.length, 90));

        int[] b = {1, 2, 4, 68, 78, 88, 88, 120, 240};
        System.out.println(bSearchFirstEquals(b, 9, 88));

        int[] c = {1, 22, 33, 44, 55, 66, 77, 88, 99, 99, 99, 100};
        System.out.println(bSearchLastEquals(c, c.length, 99));

        int[] d = {1, 22, 33, 44, 55, 66, 77, 88, 99, 99, 99, 100};
        System.out.println(bSearchFirstGreaterThan(d, d.length, 89));

        int[] e = {1, 22, 33, 44, 55, 66, 77, 88, 99, 99, 99, 120};
        System.out.println(bSearchLastLessThan(e, e.length, 100));

        double f = 1.234e2;
        System.out.println("f is: " + f);

        //byte最大127
        byte g = 127;
        System.out.println("g is: " + g);

        //65535 / 2 = 32767
        char h = 'A';
        short i = 80;

        i = (short) h;

        g = (byte) i;
        System.out.println(g);

        //int 2的31次方-1

        /*
        var input = new Scanner(System.in);
        var num = input.nextInt();
        System.out.println(num);

        //s 为\r\n
        var s = input.nextLine();
        var ss= input.nextLine();
        System.out.println(ss);
         */

        int k = 2 > 2 ? 1 : 0;
        System.out.println(k);

        System.out.println(Integer.toBinaryString(5));

        boolean j = true;

        System.out.println(!j);
        System.out.println(~2);

        {
            outloop:
            for (int l = 0; l < 8; l++) {
                for (int m = 0; m < 8; m++) {
                    if (0 != m % 2) {
                        System.out.println(l + ":" + m);
                        break outloop;
                    }
                }
            }
            /*
            int[] arr = new int[5];
            arr[0] = 123;
            System.out.println(arr[0]);
             */
            int[] arr = {1, 2, 33, 44, 5};
            var array = Arrays.copyOfRange(arr, 1, 4);
            System.out.println(Arrays.toString(array));

            Arrays.sort(arr);
            System.out.println(Arrays.toString(arr));
        }

    }

}
