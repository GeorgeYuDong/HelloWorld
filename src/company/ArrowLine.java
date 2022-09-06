package src.company;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * @author yudong
 */
public class ArrowLine extends Line {
    private boolean startArrow;
    private boolean endArrow;

    public ArrowLine(PointTwo start, PointTwo end, String color,
                     boolean startArrow, boolean endArrow) {
        super(start, end, color);
        this.startArrow = startArrow;
        this.endArrow = endArrow;
    }


    @Override
    public void draw() {
        super.draw();
        if (startArrow) {
            System.out.println("draw start arrow");
        }
        if (endArrow) {
            System.out.println("draw end arrow");
        }
    }

    @Override
    public String toString() {
        return "ArrowLine{" +
                "startArrow=" + startArrow +
                ", endArrow=" + endArrow +
                '}';
    }

    public static void main(String[] args) {
        PointTwo pointTwo = new PointTwo(0, 4);
        PointTwo pointTwo1 = new PointTwo(3, 0);

        ArrowLine arrowLine = new ArrowLine(pointTwo, pointTwo1, "red", true, true);
        arrowLine.draw();

        ArrayList<ArrowLine> arrowLines = new ArrayList<>();
        ArrayList<Line> lines = new ArrayList<>();
        ArrayList<Shape> shapes = new ArrayList<>();

        PointTwo start = new PointTwo(3, 0);
        PointTwo end = new PointTwo(0, 4);
        Line line = new Line(start, end, "red");
        lines.add(line);
        arrowLines.add(arrowLine);

        Shape shape = new Shape("red");
        shapes.add(shape);

        ArrayList<? super Shape> shapes1 = new ArrayList<Shape>();
        //存放的是Line及子类ArrowLine, 限制可写入的类型，类型越具体，子类越少，可写入的类型就越少。
        shapes1.add(arrowLine);
        shapes1.add(line);
        shapes1.add(shape);
        System.out.println("===写自己和子类对象========");
        // 写子类对象, 父类，可指向的是子类对象，利用的是多态性质。
        System.out.println(shapes1.get(0));
        System.out.println(shapes1.get(1).toString());
        System.out.println(shapes1.get(2).toString());
        System.out.println("===========");


        System.out.println("====读子类对象,分开读,读三个不同子类对象容器=======");
        // 读子类对象
        ArrayList<? extends Shape> shapes2 = lines;
        System.out.println(shapes2.get(0));
        shapes2 = arrowLines;
        System.out.println(shapes2.get(0));
        shapes2 = shapes;
        System.out.println(shapes2.get(0));


        System.out.println("===========");
        ArrayList<? extends Line> extendLines = lines;
        System.out.println(extendLines.get(0));
        extendLines = arrowLines;
        System.out.println(extendLines.get(0));
//        extendLines = shapes; 不能赋值，类型必须是Line或子类

//        ArrayList<? extends ArrowLine> extendArrowLines = lines;
//        不能赋值，类型必须是ArrowLine或子类

        System.out.println("===========");
        ArrayList<? extends ArrowLine> extendArrowLines = arrowLines;
        System.out.println(extendArrowLines.get(0));
    }
    /**
     * ArrowLine继承Line,Line继承Shape,ArrowLine对象也有Shape的属性与方法
     * */
}
