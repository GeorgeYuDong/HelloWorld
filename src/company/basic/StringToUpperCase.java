package src.company.basic;

import java.util.Scanner;

public class StringToUpperCase {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (true) {
            String s = sc.next(); // next()取字符串
            if (s.equals("a"))
                break;
            System.out.println("s = " + s.toUpperCase());
        }
    }
}
