package ch_08;

import java.util.Arrays;
import java.util.Scanner;

/**
 * *8.34 (Geometry: rightmost lowest point) In computational geometry, often you need
 * to find the rightmost lowest point in a set of points. Write the following method
 * that returns the rightmost lowest point in a set of points.
 * public static double[] getRightmostLowestPoint(double[][] points)
 * <p>
 * <p>
 * Write a test program that prompts the user to enter the coordinates of six points
 * and displays the rightmost lowest point. Here is a sample run:
 * Enter 6 points: 1.5 2.5 -3 4.5 5.6 -7 6.5 -7 8 1 10 2.5
 * The rightmost lowest point is (6.5, -7.0)
 */
public class Exercise08_34 {

    public static void main(String[] args) {
        double[][] pts = new double[6][2];

        Scanner in = new Scanner(System.in);
        System.out.print("Enter 6 points: ");
        for (int p = 0; p < 6; p++) {
            for (int n = 0; n < 2; n++) {
                pts[p][n] = in.nextDouble();
            }
        }
        System.out.print("The rightmost point is " + Arrays.toString(getRightmostLowestPoint(pts)));

    }

    public static double[] getRightmostLowestPoint(double[][] points) {
        double[] lowestRight = points[0];
        double[][] multiLowRights = new double[3][2];

        for (int i = 1; i < points.length; i++) {
            if (lowestRight[1] > points[i][1]) {
                lowestRight = points[i];
            } else if (lowestRight[1] == points[i][1]) {
                for (int z = 0; z < multiLowRights.length; z++) {
                    if (multiLowRights[z][0] == 0.0 && multiLowRights[z][1] == 0.0) {
                        multiLowRights[z] = points[i];
                        multiLowRights[z + 1] = lowestRight;
                        break;
                    }
                }
            }
        }
        if (multiLowRights[0][0] != 0.0 && multiLowRights[0][1] != 0.0 && multiLowRights[1][0] != 0.0 && multiLowRights[1][1] != 0.0) {
            for (int i = 0; i < multiLowRights.length - 1; i++) {
                if (i == 0) {
                    if (multiLowRights[i][0] > multiLowRights[i + 1][0]) {
                        lowestRight = multiLowRights[i];
                    } else {
                        lowestRight = multiLowRights[i + 1];
                    }
                } else {
                    if (multiLowRights[i][0] > lowestRight[0]) {
                        lowestRight = multiLowRights[i];
                    }
                }
            }
        }
        return lowestRight;

    }
}
