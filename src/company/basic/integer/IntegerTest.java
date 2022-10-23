package src.company.basic.integer;

public class IntegerTest {
    public static void main(String[] args) {
        int t1 = 2;
        // 转变成String类型
        String s = Integer.toString(t1);
        System.out.println("s = " + s);

        // 方法一：String转数字
        int parseInt = Integer.parseInt(s);
        System.out.println("parseInt = " + parseInt);
        // 方法二：先变成包装类，再自动拆箱
        int t2 = Integer.valueOf(s);
        System.out.println("t2 = " + t2);

        // 手动装箱
        Integer integer = Integer.valueOf(t1);
        // 手动拆箱
        int i = integer.intValue();
    }
}
