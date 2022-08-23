package company.generics;

import java.lang.reflect.Method;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.Map;

public class GenericTest {

    public static void main(String[] args) throws NoSuchMethodException {
        getParamType();
    }


    public static void getParamType() throws NoSuchMethodException {
        Method m = GenericTest.class.getMethod("applyMap", Map.class);

        System.out.println("--------genericParameterType-----------------");
        Type[] types = m.getGenericParameterTypes();
        System.out.println(types[0]);

        System.out.println("");
        System.out.println("--------rawType-----------------");
        ParameterizedType type = (ParameterizedType) types[0];
        System.out.println(type.getRawType());

        System.out.println("");
        System.out.println("--------actualType-----------------");
        System.out.println(type.getActualTypeArguments()[0]);
        System.out.println(type.getActualTypeArguments()[1]);
    }

    public static void applyMap(Map<Integer, String> map) {

    }
}
