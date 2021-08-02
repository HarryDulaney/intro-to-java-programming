package ch_09.exercise09_01;

/**
 * Exercise 9.1 (The Rectangle class) Following the example of the
 * Circle class in Section 9.2, design a class named Rectangle
 * to represent a rectangle. The class contains:
 * <p>
 * Two double data fields named width and height that specify
 * the width and height of the rectangle. The default values
 * are 1 for both width and height.
 * <p>
 * A no-arg constructor that creates a default rectangle.
 * <p>
 * A constructor that creates a rectangle with the specified width and height.
 * <p>
 * A method named getArea() that returns the area of this rectangle.
 * <p>
 * A method named getPerimeter() that returns the perimeter.
 * <p>
 * Draw the UML diagram for the class and then implement the class.
 * Write a test program that creates two Rectangle objects-one with width 4 and height 40 and the other with
 * width 3.5 and height 35.9. Display the width, height, area, and perimeter of each
 * rectangle in this order.
 */
public class Exercise09_01 {

    public static void main(String[] args) {

        Rectangle r1 = new Rectangle(4, 40);

        Rectangle r2 = new Rectangle(3.5, 35.9);

        System.out.println("The width, height, area, and perimeter of rectangle one are "
                + r1.width + " , " + r1.height + " , " + r1.getArea() + " , " + r1.getPerimeter());


        System.out.println("The width, height, area, and perimeter of rectangle two are "
                + r2.width + " , " + r2.height + " , " + r2.getArea() + " , " + r2.getPerimeter());
    }
}
