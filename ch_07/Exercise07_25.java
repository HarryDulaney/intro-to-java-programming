package ch_07;

import java.util.Scanner;

/**
 * 7.25 (Algebra: solve quadratic equations) Write a method for solving a quadratic
 * equation using the following header:
 * public static int solveQuadratic(double[] eqn, double[] roots)
 * The coefficients of a quadratic equation ax2 + bx + c = 0 are passed to the
 * array eqn and the real roots are stored in roots. The method returns the number of real roots.
 * See Programming Exercise 3.1 on how to solve a quadratic
 * equation.
 * Write a program that prompts the user to enter values for a, b, and c and displays
 * the number of real roots and all real roots.
 */
public class Exercise07_25 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        System.out.print("Enter values for a, b, and c: ");
        double a = in.nextDouble();
        double b = in.nextDouble();
        double c = in.nextDouble();

        double[] values = new double[]{a, b, c};
        double[] rootVals = new double[2];

        int numRoots = solveQuadratic(values, rootVals);
        System.out.println("The number of real roots is " + numRoots);
        if (numRoots != 0) {
            System.out.print("The real roots values are: ");
            for (double value : rootVals) {
                if (value != 0.0) {
                    System.out.print(value + " ");
                }
            }
        }
        in.close();
    }

    public static int solveQuadratic(double[] eqn, double[] roots) {

        double dis = Math.pow(eqn[1], 2) - 4 * eqn[0] * eqn[2];

        if (dis < 0) {
            return 0;
        } else if (dis == 0) {
            roots[0] = (-1 * eqn[1]) + (Math.pow(dis, 0.5) / (2 * eqn[0]));
            return 1;

        } else {
            roots[0] = (-1 * eqn[1]) + (Math.pow(dis, 0.5) / (2 * eqn[0]));
            roots[1] = (-1 * eqn[1]) - (Math.pow(dis, 0.5) / (2 * eqn[0]));
            return 2;
        }

    }
}
