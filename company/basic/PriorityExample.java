package company.basic;

public class PriorityExample {
    public static void main(String[] args) {
        int a = 7;
        int b = 2;

        boolean both = a > 0 && b > 0;
        System.out.println(both);

        //算术运算优先级大于关系运算
        boolean result = a < b + 5;
        System.out.println(result);
    }
}
