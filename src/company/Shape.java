package src.company;

import lombok.*;

/**
 * @author yudong
 */
@Data
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

    public void draw() {
        System.out.println("draw shape");
    }

}
