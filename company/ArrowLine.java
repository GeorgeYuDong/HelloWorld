package company;

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

    public static void main(String[] args) {
        PointTwo pointTwo = new PointTwo(0, 4);
        PointTwo pointTwo1 = new PointTwo(3, 0);

        ArrowLine arrowLine = new ArrowLine(pointTwo, pointTwo1, "red", true, true);
        arrowLine.draw();
    }
    /**
     * ArrowLine继承Line,Line继承Shape,ArrowLine对象也有Shape的属性与方法
     * */
}
