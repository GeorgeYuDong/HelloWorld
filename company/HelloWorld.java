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

        //-32768 ~ 32767
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
        }

        {

        }


    }
}
