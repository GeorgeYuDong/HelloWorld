package company;

/**
 * @author yudong
 */
public class Circle extends Shape {
    /**
     * 点加圆半径
     */
    private PointTwo center;
    private double r;

    public Circle(PointTwo center, double r) {
        this.center = center;
        this.r = r;
    }

    @Override
    public void draw() {
        System.out.println("draw circle at " + center.toString()
                + " with r " + r + ", using color: " + getColor());
    }

    public double area() {
        return Math.PI * r * r;
    }

    public static void main(String[] args) {
        PointTwo center = new PointTwo(2, 3);
        /**
         * 创建圆，赋值给circle
         * */
        Circle circle = new Circle(center, 2);
        /**
         * 调用draw方法，执行circle的draw方法
         */
        circle.draw();

        System.out.println(circle.area());

        /**
         * 一个类最多只能有一个父类
         * 子类不能访问父类私有属性和方法，如不能访问shape的私有实例color
         * 除私有的外，子类继承了父类的其他属性和方法
         * new的过程中，父类的构造方法也会执行, 会优先子类执行
         * shape的默认构造方法会在子类Circle的构造方法之前执行
         * */
    }
}
