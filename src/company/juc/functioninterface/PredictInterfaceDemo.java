package src.company.juc.functioninterface;

import java.util.function.Predicate;

public class PredictInterfaceDemo {
    public static void main(String[] args) {
        Predicate<String> predicate = new Predicate<>() {
            @Override
            public boolean test(String s) {
                return s.isEmpty();
            }
        };
        System.out.println(predicate.test(""));
        System.out.println(predicate.test("123"));

        // 写，思考，动脑筋更重要
        Predicate<String> predicateStr = str -> {
            return str.isEmpty();
        };
        System.out.println(predicateStr.test("abc"));
        System.out.println(predicateStr.test(""));
    }
}
