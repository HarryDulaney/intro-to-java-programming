package ch_13;

/**
 * 13.5. (Enable GeometricObject comparable) Modify the GeometricObject class to implement
 * the Comparable interface, and define a static max method in the GeometricObject class
 * for finding the larger of two GeometricObject objects. Draw the UML diagram and implement
 * the new GeometricObject class. Write a test program that uses the max method to
 * find the larger of two circles and the larger of two rectangles.
 */
public class Exercise13_05 {
    public static void main(String[] args) {


        Rectangle13_05 r1 = new Rectangle13_05(10.15, 11.55);

        Rectangle13_05 r2 = new Rectangle13_05(31.22, 12.44);

        System.out.println("The larger of the two rectangles is the one:");

        System.out.println("\n" + Rectangle13_05.max(r1, r2));

        Circle13_05 c1 = new Circle13_05(13.45);

        Circle13_05 c2 = new Circle13_05(10.15);

        System.out.println("\nThe larger of the two circles is the one:");
        System.out.println("\n" + Circle13_05.max(c1, c2));

    }


}

class Circle13_05 extends GeometricObject13_05 {

    private double radius;

    public Circle13_05() {

    }

    public Circle13_05(double radius) {

        this.radius = radius;

    }

    public Circle13_05(double radius, String color,
                       boolean filled) {

        this.radius = radius;
        setColor(color);
        setFilled(filled);

    }

    public double getRadius() {
        return radius;
    }

    public void setRadius(double radius) {
        this.radius = radius;
    }

    @Override
    public double getArea() {
        ;
        return radius * radius * Math.PI;
    }

    @Override
    public double getPerimeter() {


        return 2 * radius * Math.PI;

    }

    @Override
    public String toString() {
        return super.toString() + "\nRadius: " + getRadius() + "\nArea: "
                + getArea() + "\nPerimeter: " + getPerimeter();
    }

}

class Rectangle13_05 extends GeometricObject13_05 {

    private double width;
    private double height;

    Rectangle13_05() {
        width = 1;
        height = 1;
    }

    Rectangle13_05(double newWidth, double newHeight) {

        width = newWidth;
        height = newHeight;
    }

    public double getWidth() {
        return width;
    }

    public void setWidth(double width) {
        this.width = width;
    }

    public double getHeight() {
        return height;
    }

    public void setHeight(double height) {
        this.height = height;
    }

    @Override
    public double getArea() {
        double area = width * height;
        return area;
    }

    @Override
    public double getPerimeter() {

        return (2 * width) + (2 * height);
    }

    @Override
    public String toString() {
        return super.toString() + "\nWidth: " + width + "\nHeight: " + height
                + "\nArea: " + getArea() + "\nPerimeter: " + getPerimeter();
    }


}
