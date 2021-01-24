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
public class E0725 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        System.out.print("Enter values for a, b, and c: ");
        int a = in.nextInt();
        int b = in.nextInt();
        int c = in.nextInt();

        in.close();
    }

//    public static int solveQuadratic(double[] eqn, double[] roots) {

//        double dis = Math.pow(b, 2) - 4 * a * c;
//
//        if (dis < 0) {
//            System.out.println("The discriminate is negative, the equation has no real roots.");
//        } else if (dis == 0) {
//
//            double oneRoot = (-1 * b) + (Math.pow(dis, 0.5) / (2 * a));
//
//            System.out.print("One real root: " + oneRoot);
//
//        } else {
//
//            double root, twoRoot;
//            root = (-1 * b) + (Math.pow(dis, 0.5) / (2 * a));
//            twoRoot = (-1 * b) - (Math.pow(dis, 0.5) / (2 * a));
//
//            System.out.print("Two real roots: " + root + " " + twoRoot);
//        }

    }
