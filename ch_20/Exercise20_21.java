package ch_20;

import java.util.Arrays;
import java.util.Comparator;

/**
 * 20.21 (Use Comparator) Write the following generic method using selection sort
 * and a comparator.
 * public static <E> void selectionSort(E[] list, Comparator<? super E> comparator)
 * <p>
 * Write a test program that creates an array of 10 GeometricObjects and
 * invokes this method using the GeometricObjectComparator introduced in
 * Listing 20.4 to sort the elements. Display the sorted elements. Use the following statement to create the array.
 * GeometricObject[] list = {new Circle(5), new Rectangle(4, 5),
 * new Circle(5.5), new Rectangle(2.4, 5), new Circle(0.5),
 * new Rectangle(4, 65), new Circle(4.5), new Rectangle(4.4, 1),
 * new Circle(6.5), new Rectangle(4, 5)};
 */
public class Exercise20_21 {
    public static void main(String[] args) {
        GeometricObject[] list = {new Circle(5), new Rectangle(4, 5),
                new Circle(5.5), new Rectangle(2.4, 5), new Circle(0.5),
                new Rectangle(4, 65), new Circle(4.5), new Rectangle(4.4, 1),
                new Circle(6.5), new Rectangle(4, 5)};

        selectionSort(list, new GeometricObjectComparator());
        for (int i = 0; i < list.length; i++) {
            System.out.println("Area of GeometricObject @ list[" + i + "] = " + list[i].getArea());
        }
    }

    public static <E> void selectionSort(E[] list,
                                         Comparator<? super E> comparator) {
        for (int i = 0; i < list.length - 1; i++) {
            E currentMin = list[i];
            int currentMinIndex = i;

            for (int j = i + 1; j < list.length; j++) {
                if (comparator.compare(currentMin, list[j]) > 0) { // currentMin is greater than list at j
                    currentMin = list[j];
                    currentMinIndex = j;
                }
            }
            if (currentMinIndex != i) {
                list[currentMinIndex] = list[i];
                list[i] = currentMin;
            }
        }
    }
}


class GeometricObjectComparator
        implements Comparator<GeometricObject>, java.io.Serializable {
    public int compare(GeometricObject o1, GeometricObject o2) {
        double area1 = o1.getArea();
        double area2 = o2.getArea();
        if (area1 < area2)
            return -1;
        else if (area1 == area2)
            return 0;
        else
            return 1;
    }
}


class Circle extends GeometricObject {

    private double radius;

    public Circle() {

    }

    public Circle(double radius) {

        this.radius = radius;

    }

    public Circle(double radius, String color,
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

class Rectangle extends GeometricObject {

    private double width;
    private double height;

    public Rectangle() {
        width = 1;
        height = 1;
    }

    public Rectangle(double newWidth, double newHeight) {

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

abstract class GeometricObject {
    private String color = "white";
    private boolean filled;
    private java.util.Date dateCreated;

    /**
     * Construct a default geometric object
     */
    protected GeometricObject() {
        dateCreated = new java.util.Date();
    }

    /**
     * Construct a geometric object with color and filled value
     */
    protected GeometricObject(String color, boolean filled) {
        dateCreated = new java.util.Date();
        this.color = color;
        this.filled = filled;
    }

    /**
     * Return color
     */
    public String getColor() {
        return color;
    }

    /**
     * Set a new color
     */
    public void setColor(String color) {
        this.color = color;
    }

    /**
     * Return filled. Since filled is boolean,
     * the get method is named isFilled
     */
    public boolean isFilled() {
        return filled;
    }

    /**
     * Set a new filled
     */
    public void setFilled(boolean filled) {
        this.filled = filled;
    }

    /**
     * Get dateCreated
     */
    public java.util.Date getDateCreated() {
        return dateCreated;
    }

    @Override
    public String toString() {
        return "created on " + dateCreated + "\ncolor: " + color +
                " and filled: " + filled;
    }

    /**
     * Abstract method getArea
     */
    public abstract double getArea();

    /**
     * Abstract method getPerimeter
     */
    public abstract double getPerimeter();
}