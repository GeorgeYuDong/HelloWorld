package src.company;

import java.util.Arrays;

/**
 * @author yudong
 */
public class ComUtil {
    public static Object max(MyComparable[] objs) {
        if (objs == null || objs.length == 0) {
            return null;
        }
        MyComparable max = objs[0];
        for (int i = 1; i < objs.length; i++) {
            if (max.compareTo(objs[i]) < 0) {
                max = objs[i];
            }
        }
        return max;
    }

    public static void sort(MyComparable[] objs) {
        for (int i = 0; i < objs.length; i++) {
            int min = i;
            for (int j = i + 1; j < objs.length; j++) {
                if (objs[j].compareTo(objs[min]) < 0) {
                    min = j;
                }
            }
            if (min != i) {
                MyComparable temp = objs[i];
                objs[i] = objs[min];
                objs[min] = temp;
            }
        }
    }

    public static void main(String[] args) {
        PointTwo[] pointTwos = new PointTwo[]{
                new PointTwo(2, 3), new PointTwo(3, 4),
                new PointTwo(1, 2)
        };
        System.out.println("max: " + ComUtil.max(pointTwos));
        ComUtil.sort(pointTwos);
        System.out.println("sort: " + Arrays.toString(pointTwos));
    }
}
