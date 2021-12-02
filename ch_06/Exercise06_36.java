package ch_06;

import java.util.*;

/**
 * *6.36 (Geometry: area of a regular polygon) A regular polygon is an n-sided polygon
 * in which all sides are of the same length and all angles have the same degree (i.e.,
 * the polygon is both equilateral and equiangular).
 * <p>
 * Write a method that returns the area of a regular polygon using the following header:
 * public static double area(int n, double side)
 * <p>
 * Write a main method that prompts the user to enter the number of sides and the
 * side of a regular polygon and displays its area. Here is a sample run:
 * Enter the number of sides: 5
 * Enter the side: 6.5
 * The area of the polygon is 72.69017017488385
 *
 * @author Harry D.
 */
public class Exercise06_36 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.print("Enter the number of sides: ");
        int numSides = in.nextInt();
        System.out.print("\nEnter the side: ");
        double s = in.nextDouble();
        System.out.println("The area of the polygon is " + area(numSides, s));
    }

    public static double area(int n, double side) {
        return (n * Math.pow(side, 2)) / (4 * Math.tan(Math.PI / n));
    }
}