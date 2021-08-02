package ch_09.exercise09_10;

import java.util.Scanner;

/**
 * *9.10 (Algebra: quadratic equations) Design a class named QuadraticEquation for
 * a quadratic equation ax2 + bx + x = 0. The class contains:
 * ■ Private data fields a, b, and c that represent three coefficients.
 * ■ A constructor for the arguments for a, b, and c.
 * ■ Three getter methods for a, b, and c.
 * ■ A method named getDiscriminant() that returns the discriminant, which is
 * b2 - 4ac.
 * ■ The methods named getRoot1() and getRoot2() for returning two roots of
 * the equation
 * r1 = -b + Sqrt(b^2 - 4ac) / 2a
 * r2 = -b - Sqrt(b2 - 4ac) / 2a
 * These methods are useful only if the discriminant is non-negative.
 * Let these methods return 0 if the discriminant is negative.
 * <p>
 * Draw the UML diagram for the class and then implement the class {@link ch_09.exercise09_10.QuadraticEquation UML
 * Diagram}.
 * <p>
 * Write a test program that prompts the user to enter values for a, b, and c and displays the result
 * based on the discriminant. If the discriminant is positive, display the two roots. If
 * the discriminant is 0, display the one root. Otherwise, display “The equation has
 * no roots.” See Programming Exercise 3.1 for sample runs.
 */
public class Exercise09_10 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println("Enter values for a, b, and c: ");

        double a = in.nextDouble();
        double b = in.nextDouble();
        double c = in.nextDouble();
        QuadraticEquation quadraticEquation = new QuadraticEquation(a, b, c);

        double discriminant = quadraticEquation.getDiscriminant();
        System.out.printf("The discriminant value is %.2f", discriminant);

        if (discriminant > 0) {//-1.234 2.111 1.987
            System.out.print(" and the two root values are: ");
            System.out.printf("%.5f", quadraticEquation.getRoot1());
            System.out.print("  ");
            System.out.printf("%.5f", quadraticEquation.getRoot2());
        } else if (discriminant == 0) {
            System.out.print(" and the one root value is: ");
            System.out.println(quadraticEquation.getRoot1() + "(Root 1)");
        } else {
            System.out.println(" The equation has no roots.");
        }


    }
}
