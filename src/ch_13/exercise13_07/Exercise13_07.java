package ch_13.exercise13_07;

import java.awt.*;
import java.util.Calendar;
import java.util.Random;

/**
 * 13.7 (The Colorable interface) Design an interface named Colorable with a void
 * method named howToColor().
 * <p>
 * Every class of a colorable object must implement the Colorable interface. Design a class named Square that extends
 * GeometricObject and implements Colorable. Implement howToColor to
 * display the message Color all four sides.
 * <p>
 * Draw a UML diagram that involves Colorable, Square, and GeometricObject.
 * <p>
 * Write a test program that creates an array of five GeometricObjects. For each
 * object in the array, display its area and invoke its howToColor method if it is
 * colorable.
 */
public class Exercise13_07 {
    private static final Random randomDbl = new Random(999);

    public static void main(String[] args) {
        GeometricObject[] test = new GeometricObject[5];
        for (int i = 0; i < test.length; i++) {
            test[i] = new Square(randomDbl.nextDouble());

        }
        for (Object object : test) {
            if (object instanceof Square) {
                Square square = (Square) object;
                System.out.println("Area = " + square.getArea() + " squared");
                System.out.println("How to color method result: ");
                square.howToColor();
            }
        }


    }
}

