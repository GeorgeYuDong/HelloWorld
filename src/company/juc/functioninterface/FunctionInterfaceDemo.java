package src.company.juc.functioninterface;

import java.util.function.Function;

public class FunctionInterfaceDemo {
    public static void main(String[] args) {
        Function function = new Function() {
            @Override
            public Object apply(Object o) {
                return o;
            }
        };
        System.out.println(function.apply("abc"));

        // lambda写法
        Function<String, String> stringFunction = str -> {
            return str + " is the strongest!!";
        };
        System.out.println(stringFunction.apply("china"));
    }

}
