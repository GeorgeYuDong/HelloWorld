package company;

/**
 * @author yudong
 */
public class Line extends Shape {
    private PointTwo start;
    private PointTwo end;

    public Line(PointTwo start, PointTwo end, String color) {
        /**
         * super指代父类，调用父类构造方法，访问父类方法和变量
         * super必须放在第一行
         * super可引用父类非私有的变量
         * */
        super(color);
        this.start = start;
        this.end = end;
    }

    /**
     * 类的组合
     * <p>
     * 封装：线的长度由点决定。点的距离由Point中的方法决定。
     * 只需要构造方法给出点，距离就有了，不需要任何参数。
     * 这就是由点组成线,类的组合。
     * 设计时只考虑点，不考虑点的内部实现细节，使其他类提供更高层次的功能
     * 是程序设计的一种基本思维方式
     */
    public double length() {
        return start.distance(end);
    }

    public PointTwo getStart() {
        return start;
    }

    public void setStart(PointTwo start) {
        this.start = start;
    }

    public void setEnd(PointTwo end) {
        this.end = end;
    }

    public PointTwo getEnd() {
        return end;
    }

    /**
     * super.getColor(),super可不写
     * 如果有同名getColor,super要写，以区分，该方法调用的是父类的方法
     * <p>
     * super与this有点像，但又是不同的。
     * this引用一个对象，可以作为函数参数，可以作为返回值
     * super只是一个关键字，不能作为参数和返回值，用于告诉编译器访问父类的变量和方法
     */
    @Override
    public void draw() {
        System.out.println("draw line from "
                + start.toString() + " to " + end.toString()
                + ", using color " + super.getColor());
    }

    public static void main(String[] args) {
        PointTwo start = new PointTwo(3, 0);
        PointTwo end = new PointTwo(0, 4);
        Line line = new Line(start, end, "red");
        System.out.println("line length is " + line.length());
        System.out.println(line.getColor());
    }
}
