package company;

/**
 * @author yudong
 */
public class ShapeManager {
    private static final int MAX_NUM = 100;
    private Shape[] shapes = new Shape[MAX_NUM];
    private int shapeNum = 0;

    /**
     * 使用shapes数组保存每个shape
     */
    public void addShape(Shape shape) {
        if (shapeNum < MAX_NUM) {
            shapes[shapeNum++] = shape;
        }
    }

    /**
     * 调用每个shape子类的draw方法
     */
    public void draw() {
        for (int i = 0; i < shapeNum; i++) {
            shapes[i].draw();
        }
    }

    public static void main(String[] args) {
        /**
         * 继承的好处就是可以统一管理不同子类型的对象
         * 子类对象可赋值给父类引用变量，即向上转型
         * shape可引用Shape子类类型的对象，称为多态
         * shape:1.静态类型->Shape 2 动态类型：Circle,Line,ArrowLine
         * shapes[i].draw调用的是Circle,Line,ArrowLine的方法，称为方法的动态绑定
         *
         * 子类变量和方法与父类重名的情况下，通过super强制访问父类方法和变量
         * */
        ShapeManager shapeManager = new ShapeManager();
        shapeManager.addShape(new Circle(new PointTwo(2,3),4));
        shapeManager.addShape(new Line(new PointTwo(0,4),new PointTwo(3,0),"green"));
        shapeManager.addShape(new ArrowLine(new PointTwo(3,0),new PointTwo(0,4),"orange",true,true));
        shapeManager.draw();
    }
}
