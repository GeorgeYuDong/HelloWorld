package src.company;

/**
 * @author yudong
 */
public class PointTwo implements MyComparable<PointTwo> {
    private double x;
    private double y;

    public PointTwo(double x, double y) {
        this.x = x;
        this.y = y;
    }

    /**
     * 构造方法的返回值就是实例本身
     * 构造方法也可重载
     */
    public PointTwo(double x) {
        this.x = x;
    }

    /**
     * this(345,232)构造函数，初始化
     * 调用PointTwo(double x, double y) 构造方法
     * 即构造方法也可调用其他构造方法
     */
    public PointTwo() {
        /**
         *调用其他构造函数，必须先放在第一个，然后自己根据情况做调整
         *而不是反过来，导致自己的调整，被调用其他构造函数方法所覆盖
         */
        this(34, 56);
        this.x = 23;
        this.y = 24;
    }

    /**
     * 两个点之间的距离，sqrt((x1-x2)的平方 + (y1-y2)的平方)
     *
     * @param pointTwo
     */
    public double distance(PointTwo pointTwo) {
        return Math.sqrt(Math.pow(x - pointTwo.getX(), 2)
                + Math.pow(y - pointTwo.getY(), 2));
    }

    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }

    public void setX(double x) {
        this.x = x;
    }

    public void setY(double y) {
        this.y = y;
    }

    @Override
    public String toString() {
        return "PointTwo{" +
                "x=" + x +
                ", y=" + y +
                '}';
    }

    /**
     * PointTwo实现了MyComparable接口,T是参数类型化
     * */
    @Override
    public int compareTo(PointTwo other) {
        if (!(other instanceof PointTwo)) {
            throw new IllegalArgumentException();
        }
        PointTwo otherPoint = (PointTwo) other;
        double delta = this.distance(new PointTwo(0,0)) - otherPoint.distance(new PointTwo(0,0));
        if (delta < 0) {
            return -1;
        } else if (delta > 0) {
            return 1;
        } else {
            return 0;
        }
    }

}
