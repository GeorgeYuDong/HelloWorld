package src.company.algorithm;

public class Recursion {

    //递归是把方法当作变量对待
    public static int count(int n) {
        if (n == 1) {
            return 1;
        }
        //f(n) = f(n - 1) + 1为递推公式
        //找到终止条件，把递推公式转化为代码就行了
        //空间复杂度O（n）
        return count(n - 1) * 3;
    }

    public static int fibonacci(int n) {
        if (1 == n) {
            return 1;
        }

        if (2 == n) {
            return 2;
        }

        /*Map<>
        Object hasSolvedList ;
        if(hasSolvedList.con)
         */
        //f(n) = f(n - 1) + f(n - 2)  f(n)为总的走法步数
        // n - 1 为 1种， n - 2为1种，两者相加
        return fibonacci(n - 1) + fibonacci(n - 2);
    }

    public static int fib_one(int n) {
        if (1 == n) {
            return 1;
        }
        return fib_one(n - 1);
    }

    public static int fib_two(int n) {
        if (2 == n) {
            return 1;
        }
        return fib_two(n - 2);
    }
    //阶乘
    public static int factorial(int n) {
        if (1 == n) {
            return 1;
        }
        // f(n) = f(n - 1) * n
        return factorial(n - 1) * n;
    }

    public static void main(String[] args) {
        System.out.println(count(5));

        //爬楼梯
        System.out.println(fibonacci(3));

        //阶乘
        System.out.println(factorial(5));

        System.out.println(fib_one(9));

        System.out.println(fib_two(10));
    }
}
