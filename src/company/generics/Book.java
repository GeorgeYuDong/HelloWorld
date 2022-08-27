package src.company.generics;

public class Book {
    private int Id;
    private String Name;
    private int Price;

    public Book(int id, String name, int price) {
       this.Id = id;
       this.Name = name;
       this.Price = price;
    }

    @Override
    public String toString() {
        return this.Id + ", " + this.Name + ", " + this.Price;
    }
}
