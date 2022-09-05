package src.company.juc.functioninterface;

import java.util.function.Supplier;

public class SupplierInterfaceDemo {
    public static void main(String[] args) {
        Supplier<String> supplier = new Supplier<>() {
            @Override
            public String get() {
                return "abc";
            }
        };
        System.out.println(supplier.get());

        // 无参数（输入），只提供产品, 有返回值
        Supplier<String> stringSupplier = () -> {
            return "hello";
        };
        System.out.println(stringSupplier.get());
    }
}
