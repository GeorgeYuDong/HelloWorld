package company.reflection;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class TestRefection {

    public static void main(String[] args) throws ClassNotFoundException, NoSuchFieldException, IllegalAccessException, NoSuchMethodException, InvocationTargetException {

        Class c1 = Class.forName("company.reflection.User");
        System.out.println(c1);

        Class c2 = User.class;
        System.out.println(c2.hashCode());

        System.out.println(c1.hashCode() == c2.hashCode());

        var user = new User();
        var c3 = user.getClass();
        System.out.println(c3.hashCode());

        System.out.println("---------------------");
        System.out.println("-------get all constructors--------------");

        System.out.println("------get all public constructor-------------------------");

        var Constructors = c3.getConstructors();
        for (Constructor c :
                Constructors) {
            System.out.println(c);
        }

        System.out.println("");
        System.out.println("-------get all constructors(public, protected, private)-------------------------");
        Constructors = c3.getDeclaredConstructors();
        for (Constructor c :
                Constructors) {
            System.out.println(c);
        }

        System.out.println("------get public constructor with no parameter-------------------------");
        var con = c3.getConstructor(null);
        System.out.println(con);


        try {
            Object obj = con.newInstance();
        } catch (InstantiationException e) {
            throw new RuntimeException(e);
        }

        System.out.println("--------------------------------");
        System.out.println("--------get private constructor method-----");
        con = c3.getDeclaredConstructor(int.class);
        System.out.println(con);

        con.setAccessible(true);
        try {
            // set value by constructor
            User obj = con.newInstance(12);
            System.out.println("user id is " + obj.getId());
        } catch (InstantiationException e) {
            throw new RuntimeException(e);
        }

        System.out.println("----get all name of User and its package -------------------");
        //不包含包名
        System.out.println(c3.getSimpleName());
        System.out.println(c3.getPackage());
        System.out.println(c3.getCanonicalName());
        System.out.println(c3.getName());

        System.out.println("");
        System.out.println("----get all public fields of User object--------------------------------");
        var fieldArray = c3.getFields();
        for (Field f :
                fieldArray) {
            System.out.println(f);
        }

        System.out.println("");
        System.out.println("---------------------------");
        System.out.println("----get all fields of User object--------------------------------");
        var f = c3.getDeclaredFields();
        for (Field m :
                f) {
            m.setAccessible(true);
            System.out.println(m);
        }

        System.out.println("");
        System.out.println("--get public fields and set-------");
        Field ff = c3.getField("name");
        System.out.println(ff);

        try {
            //newInstance是构造器的方法
            User obj = c3.getConstructor().newInstance();
            ff.set(obj, "George");
            System.out.println("obj name is " + obj.getName());
        } catch (InstantiationException e) {
            throw new RuntimeException(e);
        }

        System.out.println("");
        System.out.println("------get private field and set----------------------");

        //获取private字段，需用DeclaredField
        Field privateField = c3.getDeclaredField("id");
        System.out.println(privateField);
        try {
            User obj = c3.getConstructor().newInstance();
            privateField.setAccessible(true);
            privateField.setInt(obj, 222);
            System.out.println("obj id is " + obj.getId());

            //反射可以改变已经存在的对象的值
            privateField.set(user, 1222);
            System.out.println("user id is " + user.getId());
        } catch (InstantiationException e) {
            throw new RuntimeException(e);
        }

        System.out.println("");
        System.out.println("---------get all public methods with parent methods---------------------------------");
        Method[] methods = c3.getMethods();
        for (Method m :
                methods) {
            System.out.println(m);
        }

        System.out.println("");
        System.out.println("---------get all methods with private,protected, package methods, not contain parent class methods---------------------------------");
        methods = c3.getDeclaredMethods();
        for (Method m :
                methods) {
            System.out.println(m);
        }

        System.out.println("");
        System.out.println("----get public method setName-----------------------------");
        Method m = c3.getMethod("setName", String.class);

        try {
            User obj = c3.getConstructor().newInstance();
            m.invoke(obj, "China");
            System.out.println("user name is " + obj.getName());
        } catch (InstantiationException e) {
            throw new RuntimeException(e);
        }

        System.out.println("");
        System.out.println("----get private method setName-----------------------------");
        //使用DeclaredMethod
        m = c3.getDeclaredMethod("setPhoneNum", String.class);
        System.out.println(m);

        try {
            User obj = c3.getConstructor().newInstance();
            m.setAccessible(true);
            //m.invoke(obj, para)
            m.invoke(obj, "18831243244");
            System.out.println("phone num is " + obj.getPhoneNum());

            //通过反射，使用方法对象，改变已经存在的对象的值
            m.invoke(user, "134 2231 1234");
            System.out.println("user phone num is " + user.getPhoneNum());
        } catch (InstantiationException e) {
            throw new RuntimeException(e);
        }

        System.out.println("");
        System.out.println("-------mainMethod reflect----------------------");
        m = c3.getMethod("main", String[].class);
        m.invoke(null, new Object[]{new String[]{"a", "b"}});




    }
}

