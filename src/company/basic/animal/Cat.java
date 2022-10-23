package src.company.basic.animal;

public class Cat extends Animal{
    private String sex;
    private String species;

    public Cat(String name, int age, String sex, String species) {
        super(name, age);
        this.sex = sex;
        this.species = species;
    }

    public Cat(String name, int age) {
        super(name, age);
    }

    @Override
    public String toString() {
        return "Cat{" +
                "sex='" + sex + '\'' +
                ", species='" + species + '\'' +
                ", name='" + super.getName() + '\'' +
                ", age='" + super.getAge() + '\'' +
                '}';
    }

    public static void main(String[] args) {
        Cat jason = new Cat("Jason", 2, "male", "猫咪");
        System.out.println(jason);

        String a = "a";
        a.hashCode();
    }
}
