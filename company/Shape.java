package company;

/**
 * @author yudong
 */
public class Shape {
    private static final String DEFAULT_COLOR = "black";
    private String color;

    public static String getDefaultColor() {
        return DEFAULT_COLOR;
    }

    public Shape() {
        this(DEFAULT_COLOR);
    }

    public Shape(String color) {
        this.color = color;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public void draw() {
        System.out.println("draw shape");
    }
}
