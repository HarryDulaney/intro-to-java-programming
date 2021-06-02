package ch_02;

import java.util.Scanner;

/**
 * 2.2 (Compute the volume of a cylinder) Write a program that reads in the radius
 * and length of a cylinder and computes the area and volume using the following
 * formulas:
 * area = radius * radius * pi
 * volume = area * length
 * <p>
 * Here is a sample run:
 * * Enter the radius and length of a cylinder: 5.5 12
 * * The area is 95.0331
 * * The volume is 1140.4
 */
public class Exercise02_02 {
    public static void main(String[] args) {
        System.out.print("Enter the radius and length of a cylinder: ");
        Scanner input = new Scanner(System.in);

        double radius = input.nextDouble();
        double length = input.nextDouble();

        double area = radius * radius * Math.PI;
        double volume = area * length;

        System.out.println("The area is " + area);
        System.out.println("The volume is " + volume);

        input.close();

    }

}
