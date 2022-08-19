package company.reflection;

import java.lang.reflect.Field;
import java.util.Arrays;

public class TestRefection {

    public static void main(String[] args) throws ClassNotFoundException, NoSuchFieldException, IllegalAccessException {

        Class c1 = Class.forName("company.reflection.User");
        System.out.println(c1);

        Class c2 = User.class;
        System.out.println(c2.hashCode());

        System.out.println(c1.hashCode() == c2.hashCode());

        var user = new User();
        var c3 = user.getClass();
        System.out.println(c3.hashCode());

        //不包含包名
        System.out.println(c3.getSimpleName());
        System.out.println(c3.getPackage());
        System.out.println(c3.getCanonicalName());
        System.out.println(c3.getName());

        var f = c3.getDeclaredFields();
        System.out.println(Arrays.toString(f));

        for (Field m :
                f) {
            m.setAccessible(true);
            System.out.println(m);
        }
        /*
        Field field = c3.getField("id");
        field.setAccessible(true);
        field.set(null, 12);
         */


    }
}

class User {
    private String name;
    private int id;

    public User() {

    }

    public User(String name, int id) {
        this.name = name;
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", id=" + id +
                '}';
    }
}
