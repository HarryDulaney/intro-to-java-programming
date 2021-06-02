package ch_13.exercise13_09;

import java.util.Objects;

/**
 * 13.9 (Enable Circle comparable) Rewrite the Circle class in Listing 13.2 to extend
 * GeometricObject and implement the Comparable interface. Override the
 * equals method in the Object class.
 * <p>
 * Two Circle objects are equal if their radii
 * are the same. Draw the UML diagram that involves Circle, GeometricObject,
 * and Comparable.
 */
public class Circle extends GeometricObject implements Comparable<Circle> {
    private double radius;

    @Override
    public boolean equals(Object o) {
        Circle circle = (Circle) o;
        return this.radius == circle.radius;
    }

    @Override
    public int compareTo(Circle c1) {
        if (this.radius > c1.radius) {
            return 1;
        } else if (this.radius < c1.radius) {
            return -1;
        } else {
            return 0;
        }
    }

    /**
     * Instantiates a new Circle.
     */
    public Circle() {
    }

    @Override
    public int hashCode() {
        return Objects.hash(radius);
    }

    /**
     * Instantiates a new Circle.
     *
     * @param radius the radius
     */
    public Circle(double radius) {
        this.radius = radius;
    }

    /**
     * Instantiates a new Circle.
     *
     * @param radius the radius
     * @param color  the color
     * @param filled the filled
     */
    public Circle(double radius, String color, boolean filled) {
        this.radius = radius;
        setColor(color);
        setFilled(filled);
    }


    /**
     * Return radius
     *
     * @return the radius
     */
    public double getRadius() {
        return radius;
    }


    /**
     * Sets radius.
     *
     * @param radius the radius
     */
    public void setRadius(double radius) {
        this.radius = radius;
    }


    public double getArea() {
        return radius * radius * Math.PI;
    }

    /**
     * Gets diameter.
     *
     * @return the diameter
     */
    public double getDiameter() {
        return 2 * radius;
    }


    public double getPerimeter() {
        return 2 * radius * Math.PI;
    }

    /**
     * Print circle.
     */
    public void printCircle() {
        System.out.println("The circle is created " + getDateCreated() +
                " and the radius is " + radius);
    }

}