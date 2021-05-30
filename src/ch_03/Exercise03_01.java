package ch_03;


import java.util.Scanner;

/**
 * 3.1 (Algebra: solve quadratic equations) The two roots of a quadratic equation
 * ax2 + bx + c = 0 can be obtained using the following formula:
 * r1 = -b + 2b2 - 4ac / 2a
 * and r2 = -b - 2b2 - 4ac / 2a
 * b2 - 4ac is called the discriminant of the quadratic equation. If it is positive, the
 * equation has two real roots. If it is zero, the equation has one root. If it is negative,
 * the equation has no real roots.
 * Write a program that prompts the user to enter values for a, b, and c and displays
 * the result based on the discriminant. If the discriminant is positive, display two
 * roots. If the discriminant is 0, display one root. Otherwise, display �The equation
 * has no real roots�.
 * Note that you can use Math.pow(x, 0.5) to compute SQRT(x). Here are some
 * sample runs.
 *
 */
public class Exercise03_01 {
    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        System.out.println("Enter values for a, b, and c now: ");

        double a, b, c;

        a = input.nextDouble();
        b = input.nextDouble();
        c = input.nextDouble();

        double discriminant = (b * b) - (4 * a * c);

        if (discriminant < 0) {
            System.out.println("The discriminate is negative, the equation has no real roots.");
        } else if (discriminant > 0) {
            double r1 = ((-1 * b) + Math.pow(discriminant, 0.5)) / (2 * a);
            double r2 = ((-1 * b) - Math.pow(discriminant, 0.5)) / (2 * a);

            System.out.print("Two real roots: " + r1 + ", " + r2);


        } else {
            double r = ((-1 * b) + Math.pow(discriminant, 0.5)) / (2 * a);
            System.out.print("One real root: " + r);
        }
        input.close();
    }

}
