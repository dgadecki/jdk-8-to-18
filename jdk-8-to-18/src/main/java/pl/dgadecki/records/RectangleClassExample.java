package pl.dgadecki.records;

import java.util.Objects;

record Rectangle(double length, double width) { }

// Rectangle record as a class
public final class RectangleClassExample {

    private final double length;
    private final double width;

    public RectangleClassExample(double length, double width) {
        this.length = length;
        this.width = width;
    }

    public double length() {
        return length;
    }

    public double width() {
        return width;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        RectangleClassExample rectangle = (RectangleClassExample) o;
        return Double.compare(rectangle.length, length) == 0 && Double.compare(rectangle.width, width) == 0;
    }

    @Override
    public int hashCode() {
        return Objects.hash(length, width);
    }

    @Override
    public String toString() {
        return "Rectangle[" + "length=" + length + ", width=" + width + ']';
    }
}
