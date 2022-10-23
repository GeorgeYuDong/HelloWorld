package src.company.basic;

public class PersonTest {

    public void getEat(Person person) {
       person.eat();
    }

    public static void main(String[] args) {
        PersonTest personTest = new PersonTest();
        personTest.getEat(new Person() {
            static int a = 1;
            @Override
            public void eat() {
                System.out.println("mum is eating...");
            }
        });
    }
}
