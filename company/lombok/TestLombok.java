package company.lombok;

public class TestLombok {
    public static void main(String[] args) {
        //使用了@Data注解，set和get方法都有了
        Person person = new Person();
        person.setName("dd");
        System.out.println(person.getName());
        person.setAddress("bm");
        System.out.println(person.getAddress());
    }
}
