package ch_08;

import java.io.DataOutput;
import java.util.*;

/**
 * *8.26 (Row sorting) Implement the following method to sort the rows in a
 * two-dimensional array.
 * <p>
 * A new array is returned and the original array is intact.
 * public static double[][] sortRows(double[][] m)
 * <p>
 * <p>
 * Write a test program that prompts the user to enter a 3 * 3 matrix of double
 * values and displays a new row-sorted matrix.
 * <p>
 * Here is a sample run:
 * Enter a 3-by-3 matrix row by row:
 * 0.15 0.875 0.375
 * 0.55 0.005 0.225
 * 0.30 0.12 0.4
 * The row-sorted array is
 * 0.15 0.375 0.875
 * 0.005 0.225 0.55
 * 0.12 0.30 0.4
 */
public class Exercise08_26 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        double[][] matrix = new double[3][3];

        System.out.println("Enter a 3-by-3 matrix row by row: ");
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                matrix[i][j] = in.nextDouble();
            }
        }
        double[][] res = sortRows(matrix);
        System.out.println("The row-sorted array is: ");
        for (int i = 0; i < 3; i++) {
            System.out.println(Arrays.toString(res[i]));

        }

    }

    public static double[][] sortRows(double[][] m) {
        double[][] sorted = new double[m.length][m.length];
        for (int i = 0; i < 3; i++) {
            System.arraycopy(m[i], 0, sorted[i], 0, 3);
        }

        for (int i = 0; i < sorted.length; i++) {
            boolean keepSorting = true;
            while (keepSorting) {
                keepSorting = false;
                for (int j = 0; j < sorted[i].length - 1; j++) {
                    if (sorted[i][j] > sorted[i][j + 1]) {
                        double tmp = sorted[i][j];
                        sorted[i][j] = sorted[i][j + 1];
                        sorted[i][j + 1] = tmp;
                        keepSorting = true;
                    }
                }
            }
        }
        return sorted;

    }

}