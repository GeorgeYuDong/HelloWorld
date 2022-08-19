package company;

/**
 * @author yudong
 */
public class Apple {
    private String name;
    private int age;

    public Apple(int age, String name) {
        this.age = age;
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "Apple{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }

    public static void main(String[] args) {
        Apple apple = new Apple(9, "红富士");

        String a = "abc";
        System.out.println(apple.age);
        System.out.println(apple.name);

        /**默认构造方法，如果有构造方法，默认构造方法就没了
        Apple apple1 = new Apple();
        apple1.name = "ccc";
        apple1.age = 12;
        System.out.println(apple1.name);
        System.out.println(apple1.age);
         */

        /**
         * 私有构造方法：
         * 1）不能创建类的实例，类只能被静态访问。Math和Array,类就是私有的
         * 2) 能创建类的实例，只能被类的静态方法调用。类的对象有且仅有一个，
         *    单例模式.静态方法调用私有构造方法，创建一个对象，如果对象已经
         *    创建了，就重用这个对象。
         * 3) 只是用来被其他多个构造方法调用，用于减少重复代码。
         * */

        String cityName = new String("靖江");
        System.out.println(cityName);




    }

}
