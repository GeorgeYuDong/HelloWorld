package company.reflect;

public class Reflect {
    int id;
    String name;

    public Reflect(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public static void main(String[] args) throws NoSuchFieldException, ClassNotFoundException {
        Class<Reflect> reflectClass = Reflect.class;
        System.out.println(reflectClass.hashCode());

        var reflect = new Reflect(12, "abc");
        var c2 = reflect.getClass();
        System.out.println(c2.hashCode());
        
        var c3 = Class.forName("company.reflect.Reflect");
        System.out.println(c3.hashCode());

    }
}
