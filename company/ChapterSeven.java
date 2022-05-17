package company;

/**
 * @author yudong
 */
public class ChapterSeven {

    /**
     * 包装类
     * String,StringBuilder
     * Arrays
     * 时间和日期处理
     * 随机Random
     * <p>
     * short int long byte char float double boolean
     * Integer Short Long Byte Character Float Double Boolean
     * <p>
     * 装箱: 基本类型->包装类
     * 拆箱：包装类->基本类
     */

    public static void main(String[] args) {
        /**装箱*/
        Integer a = 100;

        /**拆箱*/
        int b = a;

        System.out.println(a.intValue() == b);

        /**
         * valueOf方法：返回string为数字的对象,装箱
         * */
        Integer ab = Integer.valueOf("123");
        System.out.println(ab);
        System.out.println("ab hashCode is " + ab.hashCode());

        /**
         * Integer: compareTo返回0,1,-1
         * Byte,Short,Integer,Character(1,2(2),4)
         * hashCode就是原值
         *
         * hashCode值，都是静态方法,跟类成员变量无关，跟外界传值有关,或者是一个固定值
         * */
        System.out.println("byte hashCode is " + Byte.hashCode((byte) 124));

        System.out.println("Boolean(true) hashCode is " + Boolean.hashCode(true));
        System.out.println("Boolean(false) hashCode is " + Boolean.hashCode(false));

        System.out.println("ab.compareTo(a) is " + ab.compareTo(a));

        /**
         * Long hashCode值为高32位与低32位异或操作,返回int值
         * */
        System.out.println("long hashCode is " + Long.hashCode(1234567899L));

        System.out.println("^ compute is " + (0b000 ^ 0b101));

        /**
         * floatToIntBits,二进制表示作为hashCode值
         * double同样是二进制表示，然后返回高32位与低32位做异或的值
         * */
        System.out.println("float hashCode is " + Float.hashCode(12.34f));

        System.out.println("double hashCode is " + Double.hashCode(12.34));


         /** 包装类有构造方法
         * new 方法过时deprecated
         * 一般用静态valueOf方法
         * */

        @Deprecated
        Integer abc = new Integer(123);
        @Deprecated
        Boolean bb = new Boolean(true);
        @Deprecated
        Double dd = new Double(12.34);
        @Deprecated
        Float ff = new Float(11.11);
        @Deprecated
        Character c = new Character('A');

        /**创建对象用valueOf()方法*/
        Short sh = Short.valueOf("12");
        System.out.println(sh.shortValue());

        /**
         * 所有包装类重写了Object类的如下方法：
         * String toString()
         * int hashCode()
         * boolean equals(Object obj)
         * */
        int[][] arr = new int[3][];
        System.out.println("length is " + arr.length);

        /**
         * equals有重写
         *
         * */


        /**
         * hash值是一个int类型的数
         * 由对象中一般不变的属性映射得来，区分分组对象
         * 一个对象的哈希值不能改变，相同对象的哈希值一样
         * 不同对象的哈希值应不一样,可以有对象不同，哈希值一样的情况
         * 比如：hashCode可以是学生出生日期
         *
         * hashCode与equals联系密切，equals返回true,hashCode也必须一样
         * 反之不要求
         *
         * 子类如果重写了equals方法，必须重写hashCode方法,JAVA API尤其是
         * 容器类依赖于这个行为
         *
         *
         * */

        System.out.println("string valueOf is " + String.valueOf(123));

        String s = Integer.toString(234);
        System.out.println("s charAt is " + s.charAt(2));

        /**
         * 道，就是按照天道运行的道理，好的坏的，都会各得其所，道就是所，
         * 就是归宿，就是宿命,想透了这些便不会那么痛苦。
         * 它运行不止，但在其中的所有都会各得其所。
         * */



    }


}
