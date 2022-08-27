package src.company;

/**
 * @author yudong
 */
public class Point {
    public double x;
    public double y;
    public char ch;


    /**
     * static变量初始化
     * 静态变量初始化
     */
    public static int Static_One = 1;
    public static int Static_Two;

    //静态变量初始化
    static {
        Static_Two = 4;
    }

    public double getX() {
        return x;
    }

    public void setX(double x) {
        this.x = x;
    }

    public double getY() {
        return y;
    }

    public void setY(double y) {
        this.y = y;
    }

    @Override
    public String toString() {
        return "Point{" +
                "x=" + x +
                ", y=" + y +
                ", ch=" + "'" +
                ch + "'" +
                '}';
    }

    /**
     * 点到原点的距离,实例方法可以操作实例变量，通过this指针
     */
    public double distance() {
        return Math.sqrt(x * x + y * y);
    }


}
