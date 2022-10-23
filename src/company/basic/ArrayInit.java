package src.company.basic;

public class ArrayInit {
    public static void main(String[] args) {
        int[] intArray = new int[5]; // 数组是对象，有默认值
        for (int i = 0; i < intArray.length; i++) {
            System.out.print(intArray[i] + " ");
        }

        System.out.println();
        float[] floatsArray = new float[5]; // 数组是对象，有默认值
        for (int i = 0; i < floatsArray.length; i++) {
            System.out.print(floatsArray[i] + " ");
        }
        System.out.println();
        String[] strArray = new String[5]; // 数组是对象，有默认值
        for (int i = 0; i < strArray.length; i++) {
            System.out.print(strArray[i] + " ");
        }
        System.out.println();

        int[] arr = {1, 2, 3, 4, 5};
        for (int n :
                arr) {
            System.out.print(n + " ");
        }
        System.out.println();

        int[][] ints = new int[3][]; //二维数组可以单独定义列.每个行元素都是一个一维数组
        ints[0] = new int[4]; // 4列
        ints[1] = new int[3]; // 3列
        ints[2] = new int[1]; // 1列

        for (int n:
             ints[0]) {
            System.out.print(n + " ");
        }
        System.out.println();

        for (int n:
                ints[1]) {
            System.out.print(n + " ");
        }
        System.out.println();

        for (int n:
                ints[2]) {
            System.out.print(n + " ");
        }
        System.out.println();

        System.out.println(ints[0].length);
        System.out.println(ints[1].length);
        System.out.println(ints[2].length);

        for (int i = 0; i < ints.length; i++) {
            for (int j = 0; j < ints[i].length; j++) { // ints[i].length
                System.out.print(ints[i][j] + " "); // 输出一行
            }
            System.out.println(); // 加换行输出内存完整数组模样
        }

        // 5行3列double元素
        double[][] doubles = new double[5][3];
        for (int i = 0; i < 5 ; i++) {
            for (int j = 0; j < 3; j++) {
                System.out.print(doubles[i][j] + " ");
            }
            System.out.println();
        }

    }
}
