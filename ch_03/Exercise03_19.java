package ch_03;

import java.util.*;

/**
 * **3.19 (Compute the perimeter of a triangle) Write a program that reads three
 * edges for a triangle and computes the perimeter if the input is valid.
 * Otherwise, display that the input is invalid.
 * <p>
 * The input is valid if the sum of every pair of two edges is greater than the
 * remaining edge
 *
 */
public class Exercise03_19 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println("Enter the sides of a triangle separated by spaces: ");
        double s1 = in.nextDouble();
        double s2 = in.nextDouble();
        double s3 = in.nextDouble();

        if (s3 > (s1 + s2) || s2 > (s1 + s3) || s1 > (s3 + s2)) {
            System.out.println("Invalid Input.");
        } else {
            System.out.println("Perimeter is " + (s1 + s2 + s3));
        }
        in.close();
    }
}