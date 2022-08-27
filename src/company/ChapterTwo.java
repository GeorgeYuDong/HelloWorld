package src.company;

import java.math.BigDecimal;

/**
 * @author yudong
 */
public class ChapterTwo {
    public static void main(String[] args) {
        int a = -6;
        System.out.println(Integer.toHexString(a));
        System.out.println(Integer.toBinaryString(a));
        System.out.println(Integer.toOctalString(a));

        System.out.println("a is " + a);
        System.out.println(Long.toBinaryString(a));
        System.out.println(Long.toHexString(a));
        System.out.println(Long.toOctalString(a));

        /**
         * 左移即乘以2，左移1位，即2的1次方，2位即2的2次方
         * 二进制位，左边的位丢弃，移动1位，丢弃1位，右边补0
         * 对有符号右移，即>>，负数则高位补1，右移几位，则补几位1
         * 负数右移需要通过16进制来得出正确结果
         * 对无符号，则全部补零, 则负数无符号右移会变成正数
         */
        System.out.println("a<<2 is " + (a << 2));

        /**无符号右移，左边补0,移1位，即除2.移2位即除4,11/4=2
         */
        System.out.println("a >>> 2 is " + (a >>> 2));

        System.out.println("a >> 2 is " + (a >> 2));

        System.out.println("1073741823 hex is " + Integer.toHexString(1073741823));
        System.out.println("-1 hex is " + Integer.toHexString(-1));
        System.out.println("-6 hex is " + Integer.toHexString(-6));
        System.out.println("-2 hex is " + Integer.toHexString(-2));

        /**
         * 负数用补码表示,toHexString表示的是补码信息，
         * 要转换成十进制正数，需把补码取反，并加1，得到正整数，加符号，得到负数
         * */

        int b = 3;
        //b最右边1位为1，0b11
        b = b & 0x1;
        System.out.println("& b is " + b);

        b = 2;
        b = b | 0x1;
        System.out.println("| b is " + b);

        b = ~b;
        System.out.println("~b is " + b);

        int c = 3;
        System.out.println("b^c is " + (b ^ c));

        /**
         * 不精确才是常态
         * Java只能表示2的0， -1，-2....,1,2,...的数
         * 两种方法：1.小数转化为整数运算，结束后转为小数
         * 2.使用十进制的数据类型,如BigDecimal,效率低
         * */
        BigDecimal bigDecimal = new BigDecimal("2.01");
        BigDecimal bigDecimal1 = new BigDecimal("0.1");
        System.out.println("bigDecimal is " + bigDecimal.multiply(bigDecimal1));

        System.out.println(
                Integer.toHexString(Float.floatToIntBits(19.625f))
        );

        /**
         * 浮点数，exp和尾数，当exp大于0，即整数，小数点右移exp位
         * exponent小于0，小数点左移exponent位,可还原小数值
         * exp才是内存中存的值
         * exp = exponent + 127
         */

        /**
         * 编码：
         * 1.非unicode编码:ascii, iso 8859-1, windows-1252,GBK2312,GBK
         * GB18030,Big5
         *
         * ascii:0-31,127是不可打印字符，32-126是键盘可打印字符
         *
         * 为保持兼容性，最高位置为1，则是其他国家编码，最高位为0，则是ascii
         *
         * windows-1252, 128-159部分表示可打印字符,事实上的西欧标准，取代8859
         * 都是使用1个字节，0-255
         *
         * GB2312:两个字节，最高位都位1，高位字节0xA1~0xF7, 低位字节0xA1~0xFE
         * 最高位为0， 表示ASCII
         *
         * 7000个汉字
         *
         * GBK:固定两个字节，兼容GB2312 add 14000多个汉字，共21000汉字，包含繁体字
         * 高位：0x81~0xFE, 低位：0x40~0x7E和0x80~0xFE
         *
         * 2.unicode编码:
         * UTF-16:BE(Big Endian),LE(Little Endian)
         * 1)两个字节：U+0000~U+FfFF, u+D800~U+DBfF除外
         * 2)四个字节：U+10000~U+10FFfF
         * 前两个字节：U+D800~U+DBfF, 后两个字节U+DC00~U+DFfF
         * 区分两个还是四个字节，看前两个字节
         *
         * UTF-8:unicode编号小的，使用字节数就少。编号大的，使用的字节就多。
         * 0x00~0x7F(0~127) 0xxxxxxx 1字节
         * 0x80~0x7FF(128~2047) 110xxxxx 10xxxxxx 2个字节
         * 0x800~0xFFFF(2048~65535) 1110xxxx 10xxxxxx 10xxxxxx 3个字节
         * 0x10000~0x10FFFF(65536以上) 11110xxx 10xxxxxx 10xxxxxx 10xxxxxx 4个字节
         *
         * unicode编码，把整数，转化为二进制形式，从右到左填到对应二进制格式,x不足设置为0
         *
         * UTF-8兼容ascii,utf-32和utf-16不兼容ascii。
         * utf-8表示大多数汉字，需要三个字节
         *
         * 大部分字符在65536以内
         *
         * 编码转换：通过查找unicode与各个编码的映射表实现。
         * 如：马，gb18030转到utf-8,先查gb18030->unicode映射表，得到unicode编号
         * 然后unicode->utf-8表，得到utf-8编码
         *
         * 恢复乱码操作(逆操作)：
         * ultra:把当前编码按照B编码转换，因为当前编码是B编码转换而来,得到原来编码的二进制,即A编码。
         * 然后用其他编码解读当前A编码二进制,一个个试，试到正确的，就是对的。
         *
         * 原来的二进制编码方式A：gb18030
         * 错误解读的编码方式B：windows1252
         *
         * 不一定能恢复成功，如果转换过多次，或者有难以识别的字符，也恢复不了
         * */


        System.out.println(new BigDecimal("1.23").multiply(new BigDecimal("53.12")));




    }

}
