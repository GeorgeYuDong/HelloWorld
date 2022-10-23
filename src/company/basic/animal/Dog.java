package src.company.basic.animal;

public class Dog extends Animal {
    public Dog(String name, int age) {
        super(name, age);
    }

    public static void eat() {
        System.out.println("Dog is eating..");
    }

    @Override
    public void run() {
        System.out.println("Dog is running..");
    }

    public void sleep() {
        System.out.println("Dog is sleeping..");
    }

    public static void main(String[] args) {
        Animal dog = new Dog("abc",2);
        Animal animal = new Animal("cde", 3);
       // dog.sleep(); 不能调用子类特有的方法
        dog.run();
        animal.run();



    }
}
