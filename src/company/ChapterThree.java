package src.company;

import java.util.Arrays;
import java.util.Date;
import static java.lang.System.out;

/**
 * @author yudong
 */
public class ChapterThree {

    public static void main(String[] args) {
        int a = 100;
        int b = 3394;
        System.out.println(Math.max(a, b));
        ChapterThree.printLine();
        System.out.println("it is a question");

        double d = 12.34;

        //向上取整,13
        System.out.println(Math.ceil(d));

        //向下取整，12
        System.out.println(Math.floor(d));

        //四舍五入, 12
        System.out.println(Math.round(d));

        //随机数, (0, 1)
        System.out.println(Math.random());

        //对数
        d = 10;
        System.out.println(Math.log10(d));

        //10的2次方
        System.out.println(Math.pow(d, 2));

        //绝对值
        d = -12.34;
        System.out.println(Math.abs(d));

        int[] array = {34, 23, 78, 13, 68};
        //排序，使用Arrays类对array数组排序,sort,升序排
        Arrays.sort(array);
        System.out.println(Arrays.toString(array));

        //对已升序排列的数组进行二分查找,返回下标，前提是必须已升序排好
        System.out.println(Arrays.binarySearch(array, 34));

        //给数组元素赋相同值
        Arrays.fill(array, 66);
        System.out.println(Arrays.toString(array));

        //数组复制,返回另一个数组引用reference

        int[] arrayOne = Arrays.copyOf(array, 3);
        System.out.println(Arrays.toString(arrayOne));

        //两个数组比较，equals,返回boolean值
        System.out.println(Arrays.equals(array, arrayOne));

        /**
         * 类，自定义数据类型，除8中基本数据类型之外的数据类型
         * 8种基本数据类型，
         * byte,short,int,long,float,double,char,boolean
         * 心流可以解决一切问题
         */

        System.out.println(Math.PI);
        System.out.println(Math.E);

        //final 修饰常量，表示不能修改常量,编译器会做优化
        Point point = new Point();

        /**
         * 类成员变量有默认值，int为0，
         * boolean为false,引用为null
         * char为
         * */
        System.out.println(point.x);

        /**
         * 默认为空值
         * */
        System.out.println("point.ch is " + point.ch);
        point.ch = 'A';
        System.out.println("point.ch is " + point.ch);

        out.println(point.toString());


        point.x = 3.0;

        point.y = 4.0;
        System.out.println(point.distance());


        System.out.println(Point.Static_Two);

        PointTwo pointTwo = new PointTwo();
        System.out.println(pointTwo.getX());
        System.out.println(pointTwo.getY());

        PointTwo pointTwo1 = new PointTwo(0, 4);
        System.out.println(pointTwo1.getX());
        System.out.println(pointTwo1.getY());

        PointTwo pointTwo2 = new PointTwo(3);
        System.out.println("pointTwo2 x is " + pointTwo2.getX());
        System.out.println("pointTwo2 y is " + pointTwo2.getY());

        System.out.println(pointTwo1.toString());
        System.out.println(pointTwo2.toString());

        double distance = pointTwo2.distance(pointTwo1);
        System.out.println(distance);

        /**
         * 类加载，只有一次
         * final:修饰类变量，实例变量，表示只能被赋值一次，
         * 也可修饰实例方法和局部变量
         * */

        /**
         * 类的组合
         * */
        Date now = new Date();
        System.out.println(now);

        /**
         * 静态方法可直接用类调用
         * */
        ChapterThree.printLine();

        /**
         * Arrays是java.util下的类，完全限定名java.util.Arrays
         * 使用import关键字引入,javax是扩展包
         * */
        int[] arr = {23,12,11,53};
        Arrays.sort(arr);
        System.out.println(Arrays.toString(arr));
        /**
         * static的一个作用
         * 导入类的公开静态方法和成员
         * 不宜多用，导致不知道用的哪个类的代码
         * private/public 修饰符不写，就是包内可见,包内的类可以互相访问
         * org.apache
         * org.apache.inner是两个不同的包，互相不可见
         * protected 包可见性，子类可以访问，包内其他类也可以访问
         * private 私有，不可访问。
         * private < 默认(包) < protected < public
         *
         * jar -cvf hello.jar 最上层包名(src.company)
         * 打包的为.class文件
         * hello.jar加入类路径即可使用classpath
         * javac -> .class
         * java -> 类名 -> 最终执行结果（jvm将.class转换为机器码执行）
         * 解压命令为 jar -xvf hello.jar
         * classpath路径里面的都是编译好的class文件
         *
         * 类路径：
         * 直接的class文件，类路径就是class文件根目录
         * 对于jar文件，把他们添加到类路径下，
         * 类路径是jar包包名和包路径
         * java命令会在类路径下搜索，执行
         *
         * classpath：
         * 编译时用于确定完全限定名，运行时用于查找对应的class文件执行
         * java9 模块
         *
         *
         * */

        out.println(Arrays.toString(arr));

    }

    /**
     * static代表静态方法，类方法，不需要通过实例，即可调用
     */
    public static void printLine() {
        System.out.println();
    }

    /**
     * 函数加private修饰，外部类和实例都不能调用
     * import引入直接类，不能嵌套引入，比如import java.util.*.*无效
     *
     * 如果有重名类，只能import其中一个类，其余使用完全限定名
     *
     * static 引入类的静态公开成员和方法
     * eg.import static java.lang.System.out
     */



}

