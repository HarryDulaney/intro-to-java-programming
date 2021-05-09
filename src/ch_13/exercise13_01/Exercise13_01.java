package ch_13.exercise13_01;

import java.util.Scanner;

/**
 * **13.1 (Triangle class) Design a new Triangle class that extends the abstract
 * GeometricObject class. Draw the UML diagram for the classes Triangle
 * and GeometricObject and then implement the Triangle class. Write a test
 * program that prompts the user to enter three sides of the triangle, a color, and a
 * Boolean value to indicate whether the triangle is filled. The program should create
 * a Triangle object with these sides and set the color and filled properties using
 * the input. The program should display the area, perimeter, color, and true or false
 * to indicate whether it is filled or not.
 */
public class Exercise13_01 {
    public static void main(String[] args) throws Exception {

        double side1, side2, side3;
        String color = "";
        boolean isFilled;

        try (Scanner input = new Scanner(System.in);) {

            System.out.print("Please Enter the 3 sides of the triangle now: ");
            side1 = input.nextDouble();
            side2 = input.nextDouble();
            side3 = input.nextDouble();

            System.out.println("Now enter a color followed by true or false for if the triangle is filled: ");

            color = input.next();
            isFilled = input.nextBoolean();
        }

        Triangle triangle = new Triangle(side1, side2, side3);

        triangle.setFilled(isFilled);
        triangle.setColor(color);

        System.out.println("The area of the triangle is " + triangle.getArea() +
                "\nThe Perimeter of the triangle is " + triangle.getPerimeter() +
                "\nIts color is currently " + triangle.getColor() +
                "\nIts filled status is currently " + triangle.isFilled());
    }
}
