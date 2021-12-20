package ch_08;

import java.util.*;

/**
 * *8.13 (Locate the largest element) Write the following method that returns the location
 * of the largest element in a two-dimensional array.
 * public static int[] locateLargest(double[][] a)
 * The return value is a one-dimensional array that contains two elements. These
 * two elements indicate the row and column indices of the largest element in the
 * two-dimensional array.
 * <p>
 * Write a test program that prompts the user to enter a two-dimensional array and displays
 * the location of the largest element in the array.
 */
public class Exercise08_13 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        double[][] arrTwoDim = new double[2][5];
        System.out.println("To input a two dimensional array, input: 5 floating point numbers now: ");

        for (int i = 0; i < 5; i++) {
            arrTwoDim[0][i] = in.nextDouble();
        }

        System.out.println("Input more 5 floating point numbers now: ");

        for (int i = 0; i < 5; i++) {
            arrTwoDim[1][i] = in.nextDouble();
        }

        System.out.println("The largest is located at " + Arrays.toString(locateLargest(arrTwoDim)));


    }

    public static int[] locateLargest(double[][] a) {
        int[] largeIdx = new int[2];
        double largest = Double.MIN_VALUE;

        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < a[i].length; j++) {
                if (a[i][j] > largest) {
                    largest = a[i][j];
                    largeIdx[0] = i;
                    largeIdx[1] = j;
                }
            }
        }
        return largeIdx;
    }
}
