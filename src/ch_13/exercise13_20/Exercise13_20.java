package ch_13.exercise13_20;

import ch_13.exercise13_01.Triangle;

import java.util.Scanner;

/**
 * 13.20 (Algebra: solve quadratic equations)
 * Rewrite Programming Exercise 3.1 {@linkplain ch_03.Exercise03_01} to obtain
 * imaginary roots if the determinant is less than 0 using the Complex class {@linkplain Complex} in
 * Programming Exercise 13.17.
 * <p>
 * Here are some sample runs.<br>
 * Enter a, b, c: 1 3 1<br>
 * The roots are -0.381966 and -2.61803<br>
 * Enter a, b, c: 1 2 1<br>
 * The root is -1<br>
 * Enter a, b, c: 1 2 3<br>
 * The roots are -1.0 + 1.4142i and -1.0 + -1.4142i
 */
public class Exercise13_20 {
    public static void main(String[] args) throws Exception {
        try (Scanner input = new Scanner(System.in);) {

            System.out.print("Enter a, b, c: ");
            double side1 = input.nextDouble();
            double side2 = input.nextDouble();
            double side3 = input.nextDouble();


    }
}
