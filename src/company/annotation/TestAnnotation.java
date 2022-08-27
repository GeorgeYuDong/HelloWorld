package src.company.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@MyAnnotation
public class TestAnnotation {

    @MyAnnotation(name = "abc", id = 123)
    String name;

    int id;

    public TestAnnotation() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @MyAnnotation(schools = "china")
    public int getId() {
        return id;
    }

    @MyAnnotation(age = 12)
    public void setId(int id) {
        this.id = id;
    }

    @Deprecated
    public static void test01() {
        System.out.println("test01");
    }

    @SuppressWarnings("all")
    public static void test02() {
        System.out.println("test02");
    }

    @Override
    public String toString() {
        return "123";
    }

    /**
     * 元注解
     *
     * @Target: describe the scope of annotation applied. example-> Field, Type, Method, Constructor
     * @Retention: describe the lifecycle of annotation applied. example-> Source, Class, Runtime
     * @Document: annotation is included in Javadoc
     * @Inherited: child inherited from parent annotation
     */
    public static void main(String[] args) {
        test01();
        test02();
        System.out.println(new TestAnnotation().toString());
    }
}


@Target({ElementType.FIELD, ElementType.CONSTRUCTOR, ElementType.TYPE, ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
@interface MyAnnotation {
    String name() default "";

    int id() default 66;

    int age() default -1;

    String[] schools() default {"stanford", "USA"};

}