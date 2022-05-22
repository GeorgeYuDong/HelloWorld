package company;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @author yudong
 */
public class ChapterOne {

    public static void main(String[] args) {
        Person person = new Person("China");
        System.out.println(person.getName());
        //base type
        //reference type

        int[] arr = {1, 2, 3};
        int[] arr_1 = new int[]{1, 2, 3};
        System.out.println(arr.toString());
        System.out.println(Arrays.toString(arr));

        int[] arr_2 = new int[3];
        arr_2[0] = 1;
        arr_2[1] = 2;
        arr_2[2] = 3;
        //int[] arr_3 = new int[3]{1,3,4}; forbidden

        //自己思考，自己问自己问题，带着问题思考学习，解决问题
        int[] arr_3 = {1, 2, 4};

        int a = 2147483647 * 2;
        System.out.println(a);

        double d = 10 / 4;
        System.out.println(d);

        double d1 = 20 / (double) 4;
        System.out.println(d1);

        double d2 = 0.1 * 0.1;
        System.out.println(d2);

        float d3 = 0.1f * 0.1f;
        System.out.println(d3);

        int[] arr_4 = new int[]{1, 2, 3};
        System.out.println(Arrays.toString(arr_4));

        //content is same, but reference is different
        System.out.println(arr_1 == arr_4);

        int[] arr_5 = new int[]{3, 4, 5};
        int[] arr_6 = arr_5;
        System.out.println(arr_5 == arr_6);

        //logic algo apply for boolean data
        //短路与 &&,第一个为false,就不计算后面的了。条件苛刻,为了方便行之
        System.out.println((1 > 2) && (1 == 1));

        //短路或 ||，第一个为true,就不计算后面的了,为了方便
        System.out.println((2 > 1) || (0 > 1));

        int b = 0;
        System.out.println((2 > 1) | (b++ == 0));
        //b++执行了
        System.out.println(b);

        b = 0;
        System.out.println((2 > 1) || (b++ == 0));
        //b++不执行了,即短路或
        System.out.println(b);

        int c = 10;
        if (c % 5 == 0) {
            System.out.println("偶数");
        } else {
            System.out.println("奇数");
        }

        int x = 6;
        int y = 5;
        int max = x > y ? x : y;
        System.out.println(max);

        int min = x < y ? x : y;
        System.out.println(min);

        double score = 12.34;
        if (score > 60 && score < 70) {
            System.out.println("及格");
        } else if (score > 80 && score < 90) {
            System.out.println("良好");
        } else if (score < 60) {
            System.out.println("不及格");
        }

        //switch 表达式的值有byte,int,short,char,enum,String
        switch ((int) score) {
            case 58:
                System.out.println("lowly");
                break;
            case 83:
                System.out.println("good");
                break;
            default:
                System.out.println("little good");
                break;
        }

        //case值,不可以用long。跳转表，String,用hashcode
        //跳转表：{值,跳转地址}
        //byte,short,int,char,String,枚举
        //枚举也有对应的整数值
        //条件跳转，无条件跳转

        //顺序执行，条件执行，循环执行
        //while
        Scanner in = new Scanner(System.in);
        int password = 6789;
        System.out.println(Integer.toBinaryString(password));
        int num = 0;
        /**
         int num = in.nextInt();
         while (num != password) {
         System.out.println("please input password");
         num = in.nextInt();
         }
         */

        /**
         //execute one time at least
         do {
         System.out.println("please input password");
         num = in.nextInt();
         } while (num != password);
         System.out.println("correct");
         in.close();
         */

        /**
         * 条件跳转：if(i>=arr_1.length),跳转到145
         * */
        for (int i = 0; i < arr_1.length; i++) {
            System.out.println(arr_1[i]);
            /**无条件跳转:跳转到143*/
        }

        System.out.println("foreach");
        //无需索引变量，简单遍历，使用foreach即可
        for (int elem :
                arr_1) {
            if (elem == 2) {
                System.out.println("found");
                break;
            }
            System.out.println(elem);
        }

        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == 1) {
                continue;
            }
            //等价于 if(arr[i] != 1){输出arr[i]}
            System.out.println(arr[i]);
        }

        //循环可处理，查找过滤数据，批量转换数据，统计汇总

        //函数：减少重复代码，分解复杂操作
        System.out.println(sum(2, 3));
        print3Lines();
        System.out.println(sum(78, 24));

        System.out.println(Arrays.toString(arr));
        reset(arr);
        //reset后发生了改变
        System.out.println(Arrays.toString(arr));

        int aa = 0b100;
        System.out.println(aa >>> 3);
        System.out.println(aa >> 1);

        //可变长度的参数,入参个数不确定
        System.out.println(max(3, 83, 23, 35));
        System.out.println(max(34, 24, 67));

        char a_1 = 'a';
        char b_1 = 'b';
        //函数重载，调用Math.max(int a, int b)
        System.out.println(Math.max(a_1, b_1));

        //递归函数
        long fac = fac(3);
        System.out.println(fac);
        System.out.println(factorial(0));

        char ch = '1';
        System.out.println("ch is " + (int) ch);

        int cc = '1';
        System.out.println("cc is " + cc);

        /**
         * 字符处理，采用的是unicode.具体编码格式是UTF-16BE编码，
         * 表示两个或4个字节
         * char 本质是无符号正整数，对应于unicode编号，该编号对应的字符，
         * 即该字符
         * 两个char, 4个字节，使用类Character,String方法
         * */
        char ch1 = 0x9a6c;
        System.out.println("ch1 is " + ch1);

        /**
         * 按unicode字符形式赋值,加u标记
         * */
        char ch2 = '\u9a6d';
        System.out.println("ch2 is " + ch2);

        System.out.println("2 的 16 次方为 " + Math.pow(2, 16));

    }

    public static int sum(int a, int b) {
        return a + b;
    }

    public static void print3Lines() {
        for (int i = 0; i < 3; i++) {
            System.out.println();
        }
    }

    public static void reset(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            arr[i] = i;
        }
    }

    /**
     * 可变长度参数只能是最后一个，只能是一个。
     */
    public static int max(int min, int... arr) {
        int max = min;
        for (int i = 0; i < arr.length; i++) {
            if (max < arr[i]) {
                max = arr[i];
            }
        }
        return max;
    }

    public static long fac(int n) {
        if (0 == n) {
            return 1;
        } else {
            long fac = fac(n - 1) * n;
            return fac;
        }
    }

    /**
     * 改为非递归，为循环
     */
    public static long factorial(int n) {
        long fac = 1;

        if (n == 0) {
            return 1;
        } else {
            for (int i = 1; i <= n; i++) {
                fac = fac * i;
            }
            return fac;
        }
    }

    //函数返回值，放到寄存器，或者另外的栈中
    //函数调用结束，堆空间，如果没有栈内存变量引用它，会进行自动垃圾回收
    //堆空间也会进行释放

    //入栈先是入参变量，然后是返回的下一条指令地址，


}
