package src.company.basic;

public class FacSum { // 求阶乘之和 step over 单步执行，不会进入子函数
    public static void main(String[] args) {
        int s = 1, sum = 0; // 求 1! + 2! + 3!
        for (int i = 1; i <= 5; i++) { // step into 进入子函数执行
            s = 1; // step out 执行完子函数剩余部分，返回上一层调用函数
            for (int j = 1; j <= i; j++) {
               s = s * j;
            }
            sum += s;
        }
        System.out.println("sum = " + sum);

        String str = "hello";
        if (str.equals("heLL")) {
            System.out.println("equal");
        } else {
            System.out.println("no equal");
        }
    }
}
