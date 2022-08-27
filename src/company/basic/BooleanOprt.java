package src.company.basic;

public class BooleanOprt {
    public static void main(String[] args) {
        boolean a = true;
        boolean b = false;

        System.out.println(a && b);
        System.out.println(a & b);
        System.out.println(a || b);
        System.out.println(a | b);

        // ||短路与，a= true,则为true
        System.out.println(a || (10 / 0 > 1));

        // | 长路与，|两边全部都执行，出错会直接报错，而不会显示true
        System.out.println(a | (10 / 0 > 1));
    }
}
