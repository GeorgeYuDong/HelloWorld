package company;

import java.util.Scanner;

/**
 * @author yudong
 */
public class HelloWorld {

    private String name;
    private int age;

    public static void main(String[] args) {
        System.out.println("hello,world");

        //-32768 ~ 32767 Java只定义了带符号的整数，也就是说没有无符号整数，这和C语言不一样
        //2 byte
        short a = 30000;
        System.out.println("a is " + a);

        //2 byte
        char b = 'c';
        System.out.println("char value is " + b);

        //1 byte
        boolean condition = false;
        System.out.println("boolean value is " + condition);

        //8 byte
        long b3 = 99999999999999999L;

        //4 byte default
        int b4 = 44;

        //4 byte
        float b5 = 12.344444444444f;
        System.out.println("float b5 is " + b5);

        //double 位数多了后精确度不准
        //不能用float,double定义小数点位数值
        double dl = 12.344444444444f;
        System.out.println("double dl is " + dl);

        //8 byte default
        double b6 = 13.23;

        //1 byte
        byte b7 = 127;
        System.out.println("one byte max is " + b7);

        byte b8 = 125;
        System.out.println("b7 + b8 = " + (b7 + b8));

        a = (short) b;

        System.out.println("HelloWorld.main");

        System.out.println(a);
        System.out.println(Integer.toBinaryString(a));

        System.out.println(2 + 3);

        //must initialize
        //4 byte
        int c = 9;
        System.out.println(c);

        System.out.println(2 / 3);

        float f1 = 12.34f;
        System.out.println("float is " + f1);

        //0b represent binary
        byte bb = 0b1111;
        System.out.println("bb is " + bb);

        bb >>= 1;
        System.out.println("bb >> 1 is " + bb);

        //unsigned >>
        System.out.println("bb >>> 1 is " + (bb >>> 1));
        System.out.println("bb >>> 2 is " + (bb >>> 2));

        //signed >>
        System.out.println("bb >> 2 is " + (bb >> 2));

        //0 represent oct
        byte oct = 075;
        System.out.println("oct is " + oct);

        //0x represent hex
        byte hex = 0x11;
        System.out.println("hex is " + hex);

        System.out.println("oct & hex is " + (oct & hex));
        System.out.println("oct | hex is " + (oct | hex));
        System.out.println("oct ^ hex is " + (oct ^ hex));
        System.out.println("~oct is " + (~oct));

        //low to high, auto no problem convert
        int aa = 1;
        long bbb = a;

        char ch1 = 'A';
        int alpha1 = ch1;

        //high to low, probably occur question
        aa = (int) bbb;

        int alpha = 65;
        char ch = (char) alpha;
        System.out.println("ch is " + ch);

        //stackoverflow
        int intVal = 2000000000;
        System.out.println(intVal + intVal);

        //data drop
        double doubleVal = 123.123456789123456;
        float floatVal = (float) doubleVal;
        System.out.println("floatVal is " + floatVal);
        System.out.println("doubleVal is " + doubleVal);

        //java utf-16 unicode, so char contains two bytes

        //\t represents vertical align
        //String is not the java basis datatype
        //String is not the keyword
        String content = "\taa\tbb\n";
        System.out.println(content);

        int dd = 1;
        System.out.println("dd++ is " + dd++);
        System.out.println("dd is " + dd);

        int num = 65;
        char chh = (char) num;

        for (int i = 0; i < 26; i++) {
            System.out.println(num++ + "\t" + chh++);
            for (int j = 0; j < 3; j++) {
                if (j == 1) {
                    System.out.println("break");
                    break;
                }
                System.out.println("convert ");
            }

        }

        //code segment can define same value
        //inner code segment can refer outer value
        {
            int ch11 = 'A';
            ch = 'Z';
            System.out.println(ch);
        }
        {
            int ch11 = 'B';
        }

        {
            for (int i = 0; i < 10; i++) {
                String line = "";
                for (int j = 0; j < 10; j++) {
                    if (j > i) {
                        break;
                    }
                    line += i + "*" + j + "=" + (i * j) + "\t";
                }
                System.out.println(line);
            }
        }

        //
        /*

         */
        {
            double randNum = 0;
            while (randNum < 0.5) {
                randNum = Math.random();
                System.out.println(randNum);
            }
        }

        {
            /*
            Scanner in = new Scanner(System.in);
            String s = in.nextLine();
            System.out.println(s);
             */

            int totalNum = 6;
            String[] scoreNames = new String[totalNum];
            scoreNames[0] = "语文";
            System.out.println(scoreNames[0]);
            System.out.println(scoreNames.length);
        }

        {
            System.out.println("hello");
        }

        {
            String name;
            int age;
            HelloWorld h1 = new HelloWorld();

            //default value
            System.out.println(h1.name);
            System.out.println(h1.age);

            h1.age = 11;
            h1.name = "abc";
            h1.age += 2;
            System.out.println(h1);
            System.out.println(h1.name);
            System.out.println(h1.age);
            System.out.println("hello,world");
            final double AI = 3.5;

            StringBuilder sb = new StringBuilder();
            sb.append("abc");
            sb.append("efg");
            System.out.println(sb.toString());
            // var 可以少写类型,编译器自我推断
            var sbb = new StringBuilder();
            sbb.append("cde");
            sbb.append("hjk");
            System.out.println(sbb.toString());

            int n = 100;
            System.out.println("n = " + n);

            n = 200;
            System.out.println("n = " + n);

            n += 500;
            System.out.println("n = " + n);

            // 除数为0， 编译不报错， 运行报错

            // 无符号右移，高位补零
            n = -536870912;
            System.out.println(Integer.toBinaryString(n));
            var strN = Integer.toBinaryString(n).toString();
            System.out.println(strN.length());

            int abcfirst = n >>> 1;
            System.out.println(Integer.toBinaryString(abcfirst));
            var strfirst = Integer.toBinaryString(abcfirst).toString();
            System.out.println(strfirst.length());

            int abcsecond = n >>> 2;
            System.out.println(Integer.toBinaryString(abcsecond));
            var strSecond = Integer.toBinaryString(abcsecond).toString();
            System.out.println(strSecond.length());

            int abcthird = n >>> 29;
            System.out.println(Integer.toBinaryString(abcthird));
            int abcfourth = n >>> 31;
            System.out.println(Integer.toBinaryString(abcfourth));

            //short, byte auto convert to int
            //short 整数最大值2的15次方-1
            var abcfive = Math.pow(2, 15) - 1;
            System.out.println(abcfive);

            var abcsixth = 2_000_000_000;
            System.out.println(abcsixth);

            var abcseventh = 0b000001000001;
            System.out.println(Integer.toBinaryString(abcseventh));

            boolean b1 = true;
            System.out.println(b1);

            //float number do not have bit operation

            //compare two float numbers whether is equal or not
            //float number can not represent right
            float x = 2.5f, y = 2.3f;
            float r = Math.abs(x - y);
            if (r < 0.00000001) {
                System.out.println("equal");
            } else {
                System.out.println("not equal");
            }

            //NaN Infinity -Infinity
            //float时, 0 as 除数 不报错
            var d1 = 0.0 / 0;
            System.out.println(d1);
            var d2 = 1.0 / 0;
            System.out.println(d2);
            var d3 = -1.0 / 0;
            System.out.println(d3);

            var n1 = (int) 12.3;
            System.out.println(n1);

            var n2 = (int) 1.2e20;
            System.out.println(n2);

            var n3 = Math.pow(2, 31) - 1;
            System.out.println(n3);

            // 四舍五入
            var n4 = (int) (12.7 + 0.5);
            System.out.println(n4);

            System.out.println("");
            var n5 = -1;
            var n6 = n5 << 1;
            System.out.println(Integer.toBinaryString(n6));
            System.out.println(Integer.toBinaryString(n6).toString().length());
            System.out.println(n6);

            System.out.println("");
            var n7 = 7;
            var n8 = n7 << 29;
            System.out.println(Integer.toBinaryString(n8));
            System.out.println(n8);

            System.out.println("");
            n = -536870912;
            System.out.println(Integer.toBinaryString(n));
            System.out.println(Integer.toBinaryString(n).length());

            // right move clear
            var n9 = n >> 1;
            System.out.println(Integer.toBinaryString(n9));

            var n10 = n >> 3;
            System.out.println(Integer.toBinaryString(n10));

            // left move
            System.out.println("");
            n = 7;
            System.out.println(Integer.toBinaryString(n).toString());

            var n11 = n << 1;
            System.out.println(Integer.toBinaryString(n11).toString());
            System.out.println(n11);

            System.out.println("");
            var n12 = n << 29;
            System.out.println(Integer.toBinaryString(n12).toString());
            System.out.println(Integer.toBinaryString(n12).toString().length());
            System.out.println(n12);
            System.out.println("");

            var n13 = n << 32;
            System.out.println(Integer.toBinaryString(n13).toString());
            System.out.println(Integer.toBinaryString(n13).toString().length());
            System.out.println(n13);

            System.out.println("");
            var n14 = n << 33;
            System.out.println(Integer.toBinaryString(n14).toString());
            System.out.println(Integer.toBinaryString(n14).toString().length());
            System.out.println(n14);

            System.out.println("");
            n = 0 | 0;
            System.out.println(n);

            n = 0 | 1;
            System.out.println(n);

            System.out.println("");
            n = ~1; //-2
            System.out.println(n);
            n = ~0; //-1
            System.out.println(n);

            System.out.println("");
            n = 1 ^ 0;
            System.out.println(n);
            n = 1 ^ 1;
            System.out.println(n);
            n = 0 ^ 0;
            System.out.println(n);

            System.out.println("");
            var isGreater = 5 > 3;
            System.out.println(isGreater);

            var adult = 12;
            var isZero = adult == 0;
            System.out.println(isZero);

            System.out.println("");
            System.out.println("boolean operation");
            // 短路运算，第一个表达式确定真假后，后面不再计算
            var result = true || (0 > 5);
            System.out.println(result);

            //三目运算符
            n = -100;
            var m = n > 0 ? n + 1 : -n + 2;
            System.out.println(m);

            System.out.println("");
            System.out.println("character chapter");
            var c1 = '中';
            System.out.println(c1);
            //tc is unicode of c1
            System.out.println("unicode of char, int c = char");
            int tc = c1;
            System.out.println(tc);

            System.out.println("");
            System.out.println("\\u + unicode consist of character");
            // 反斜杠 + u + hex unicode number represent character
            char c2 = '\u4e2d';
            System.out.println(c2);

            var c3 = '\u0041'; //65
            //string + (string)other type
            System.out.println("c3 character is " + c3);

            System.out.println("");
            System.out.println("hex to decimal, use Integer.parseInt");
            var dec = Integer.parseInt("4e2d", 16);
            System.out.println(dec);

            System.out.println("character of convert meaning");
            System.out.println("\\");
            System.out.println("\"");
            System.out.println("\'");
            System.out.println("\r"); //回车
            System.out.println("\t"); //tab

            /*
            var s = """
                    select * from 
                        abc
                    where id > 100 
                    """;
            System.out.println(s);

            var t = s;
            s = "world";
            System.out.println(t);

            System.out.println(s);
             */

            var arr = new int[]{1, 2, 3, 4};
            //foreach, 记得要加var，定义类型
            for (var element :
                    arr) {
                System.out.println(element * 3);
            }
            System.out.println("lucy fall in love with lili");

            



        }

        {

        }


    }

}
