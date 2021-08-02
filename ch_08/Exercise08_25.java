package ch_08;

import java.util.*;

/**
 * *8.25 (Markov matrix) An n * n matrix is called a positive Markov matrix if each
 * element is positive and the sum of the elements in each column is 1. Write the
 * following method to check whether a matrix is a Markov matrix.
 * public static boolean isMarkovMatrix(double[][] m)
 * <p>
 * Write a test program that prompts the user to enter a 3 * 3 matrix of double
 * values and tests whether it is a Markov matrix. Here are sample runs:
 * Enter a 3-by-3 matrix row by row:
 * 0.15 0.875 0.375
 * 0.55 0.005 0.225
 * 0.30 0.12 0.4
 * It is a Markov matrix
 * Enter a 3-by-3 matrix row by row:
 * 0.95 -0.875 0.375
 * 0.65 0.005 0.225
 * 0.30 0.22 -0.4
 * It is not a Markov matrix
 *
 * @author Harry D.
 */
public class Exercise08_25 {
    static String markovMatrix = "It is a Markov matrix";
    static String notMarkovMatrix = "It is not a Markov matrix";

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        double[][] test = new double[3][3];

        System.out.println("Enter a 3-by-3 matrix row by row: ");

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                test[i][j] = in.nextDouble();
            }
        }
        if (isMarkovMatrix(test)) {
            System.out.println(markovMatrix);
        } else {
            System.out.println(notMarkovMatrix);
        }
        in.close();


    }

    public static boolean isMarkovMatrix(double[][] m) {
        for (int i = 0; i < 3; i++) {
            double sum = 0;
            for (int j = 0; j < 3; j++) {
                if (m[j][i] < 0) {
                    return false;
                }
                sum += m[j][i];
            }
            if (sum != 1) {
                return false;
            }
        }
        return true;

    }
}