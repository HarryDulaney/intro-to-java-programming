package ch_13.exercise13_01;

import java.util.Scanner;

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
