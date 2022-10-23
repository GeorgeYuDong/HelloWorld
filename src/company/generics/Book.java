package src.company.generics;

public class Book {
    private int Id;
    private String Name;
    private int Price;

    public Book() {
        System.out.println("this is a non-parameter constructor method");
    }

    public Book(int id, String name, int price) {
       this(); // 只能放在第一行
       this.Id = id;
       this.Name = name;
       this.Price = price;
    }

    @Override
    public String toString() {
        return this.Id + ", " + this.Name + ", " + this.Price;
    }

}
