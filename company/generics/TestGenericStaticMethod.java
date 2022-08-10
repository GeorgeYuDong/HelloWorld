package company.generics;

public class TestGenericStaticMethod {

    public static <T> void List(T book) {
        if (book != null) {
            System.out.println(book);
        }
    }

    public static void main(String[] args) {
        Book stu = new Book(1,"learn java", 28);
        List(stu);
    }
}
