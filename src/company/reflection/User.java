package src.company.reflection;

public class User {
    public String name;
    private int id;

    char sex;

    protected String phoneNum;

    private void setPhoneNum(String phoneNum) {
        this.phoneNum = phoneNum;
    }

    public String getPhoneNum() {
        return phoneNum;
    }

    protected void show() {
        System.out.println("protected show method is invoked");
    }
    public void show2() {
        System.out.println("public show method is invoked");
    }
    public User() {
    }

    public User(String name, int id) {
        this.name = name;
        this.id = id;
    }

    protected User(boolean n) {
        System.out.println("protected constructor method " + n);
    }

    private User(int id) {
        this.id = id;
        System.out.println("private user id is " + id);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", id=" + id +
                ", sex=" + sex +
                ", phoneNum='" + phoneNum + '\'' +
                '}';
    }

    public static void main(String[] args) {
        System.out.println("main method executed");
    }
}
