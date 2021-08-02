package ch_08;

import java.util.Scanner;

/**
 * *8.30 (Algebra: solve linear equations) Write a method that solves the following
 * 2 * 2 system of linear equations:
 * a00x + a01y = b0
 * a10x + a11y = b1
 * x =
 * b0a11 - b1a01
 * a00a11 - a01a10
 * y =
 * b1a00 - b0a10
 * a00a11 - a01a10
 * The method header is
 * public static double[] linearEquation(double[][] a, double[] b)
 * The method returns null if a00a11 - a01a10 is 0.
 * <p>
 * Write a test program that
 * prompts the user to enter a00, a01, a10, a11, b0, and b1, and displays the result. If
 * a00a11 - a01a10 is 0, report that “The equation has no solution.” A sample run is
 * similar to Programming Exercise 3.3.
 */
public class Exercise08_30 {

    public static void main(String[] args) {
        double[][] a = new double[2][2];
        double[] b = new double[2];

        Scanner in = new Scanner(System.in);
        System.out.print("Enter a00, a01, a10, a11, b0, and b1: ");
        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < a[i].length; j++) {
                a[i][j] = in.nextDouble();
            }
        }
        for (int i = 0; i < b.length; i++) {
            b[i] = in.nextDouble();
        }
        double[] res = linearEquation(a, b);
        System.out.println("Value of x is " + res[0]);
        System.out.println("Value of y is " + res[1]);
    }


    public static double[] linearEquation(double[][] a, double[] b) {
        double x = (b[0] * a[1][1]) - (b[1] * a[0][1]) / (a[0][0] * a[1][1]) - (a[0][1] * a[1][0]);
        double y = (b[1] * a[0][0]) - (b[0] * a[1][0]) / (a[0][0] * a[1][1]) - (a[0][1] * a[1][0]);
        return new double[]{x, y};
    }
}
