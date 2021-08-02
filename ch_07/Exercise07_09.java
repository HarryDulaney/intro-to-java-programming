package ch_07;

import java.util.*;

/**
 * 7.9 (Find the smallest element) Write a method that finds the smallest element in an
 * array of double values using the following header:
 * public static double min(double[] array)
 * Write a test program that prompts the user to enter ten numbers, invokes this
 * method to return the minimum value, and displays the minimum value. Here is a
 * sample run of the program:
 * Enter ten numbers: 1.9 2.5 3.7 2 1.5 6 3 4 5 2
 * The minimum number is: 1.5
 *
 * @author Harry Dulaney
 */
public class Exercise07_09 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        double[] a = new double[10];

        System.out.println("Enter ten numbers: ");
        for (int i = 0; i < 10; i++) {
            a[i] = in.nextDouble();
        }
        System.out.println("The minimum number is: " + min(a));
        in.close();
    }

    public static double min(double[] array) {
        double min = Double.MAX_VALUE;
        for (int i = 0; i < array.length; i++) {
            min = Math.min(min, array[i]);
        }
        return min;
    }
}