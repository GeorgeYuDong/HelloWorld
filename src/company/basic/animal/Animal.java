package src.company.basic.animal;

import lombok.Data;

@Data
public class Animal {
    private String name;
    private int age;

    public Animal(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public void run() {
        System.out.println("animal is running..");
    }

    public static void eat() {
        System.out.println("animal is eating...");
    }
}
