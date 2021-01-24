package ch_08;

import java.util.*;


/**
 * *8.15 (Geometry: same line?) Programming Exercise 6.39 gives a method for testing
 * whether three points are on the same line.
 * Write the following method to test whether all the points in the array points are
 * on the same line.
 * public static boolean sameLine(double[][] points)
 * Write a program that prompts the user to enter five points and displays whether
 * they are on the same line. Here are sample runs:
 * Enter five points: 3.4 2 6.5 9.5 2.3 2.3 5.5 5 -5 4
 * The five points are not on the same line
 * <p>
 * From Ex 6.39 via Ex 3.32, if
 * (x1 - x0)*(y2 - y0) - (x2 - x0)*(y1 - y0) == 0
 */

public class Exercise08_15 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println("Enter five points: ");
        double[][] points = new double[5][5];

        for (int i = 0; i < points.length; i++) {
            for (int j = 0; j < 2; j++) {
                points[i][j] = in.nextDouble();
            }
        }

        if (sameLine(points)) {
            System.out.println("The points are on the same line.");
        } else {
            System.out.println("The points are not on the same line.");
        }


    }

    static boolean sameLine(double[][] points) {
        for (int i = 0; i < points.length - 2; i++) {
            double det = findDeterminate(points, 0);
            if (det != 0) {
                return false;
            }
        }
        return true;

    }

    static double findDeterminate(double[][] pts, int index) {
        return (pts[index + 1][0] - pts[index][0]) * (pts[index + 2][1] - pts[index][1]) - (pts[index + 2][0] - pts[index][0]) * (pts[index + 1][1] - pts[index][1]);

    }


}