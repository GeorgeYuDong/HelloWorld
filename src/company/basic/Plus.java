package src.company.basic;

public class Plus {

    public int plus(int m, int n) {
       return m + n;
    }

    public double plus(double m, double n) {
        return m + n;
    }

    public static void main(String[] args) {
        Plus plus = new Plus();
        int sum = plus.plus(3, 5);
        System.out.println(sum);
        double sum_1 = plus.plus(2.8, 3.4);
        System.out.println(sum_1);
    }
}
