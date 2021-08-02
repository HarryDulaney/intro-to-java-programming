package ch_13.exercise13_20;

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
    public static void main(String[] args) {

        try (Scanner input = new Scanner(System.in)) {

            System.out.print("Enter a, b, c: ");

            double a = input.nextDouble();
            double b = input.nextDouble();
            double c = input.nextDouble();

            double discriminant = b * b - 4 * a * c;

            if (discriminant > 0) {
                double r1 = ((-1 * b) + Math.sqrt(discriminant)) / (2 * a);
                double r2 = ((-1 * b) - Math.sqrt(discriminant)) / (2 * a);
                System.out.printf("Two real roots: %2.5f and %2.5f", r1, r2);

            } else if (discriminant == 0) {
                double r = ((-1 * b) + Math.sqrt(discriminant)) / (2 * a);
                System.out.print("One real root: " + r);

            } else { /* Discriminant must be less than zero */
                Complex complexR1 = new Complex(-b / (2 * a), Math.sqrt(2 * a));
                Complex complexR2 = new Complex(-b / (2 * a), -Math.sqrt(2 * a));
                System.out.println("The roots are " + complexR1 + " and " + complexR2);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
