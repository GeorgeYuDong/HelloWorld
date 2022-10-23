package src.company.basic;

public class StarDemo {
    public static void main(String[] args) {
        int n = 1;
        int m = 1;
        while (m <= 4) {
            n = 1;
       //     while (n <= m) { //直角三角形
            while (n <= 4) { //正方形4*4
                System.out.print("*");
                n++;
            }
            System.out.println();
            m++;
        }
    }
}
