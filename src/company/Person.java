package src.company;

import java.math.BigDecimal;

/**
 * @author yudong
 */
public class Person {
    private String name;

    public Person(String name) {
        this.name = name;
    }

    private Person father;
    /**
     * 类里面可以定义自己为属性
     */
    private Person mother;

    private Person[] children;

    public String getName() {
        return name;
    }

    public static void main(String[] args) {
        Person person = new Person("abc");
        //private is visible in inner class
        System.out.println(person.getName());

        BigDecimal bigDecimal = new BigDecimal("0");

        for (int i = 0; i < 101; i++) {
            bigDecimal = bigDecimal.add(new BigDecimal(Integer.toString(i)));
        }

        System.out.println(bigDecimal.intValue());

    }
}
