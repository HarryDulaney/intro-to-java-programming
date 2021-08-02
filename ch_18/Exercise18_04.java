package ch_18;

/**
 * 18.4 (Sum series) Write a recursive method to compute the following series:
 * m(i) = 1 + 1/2 + 1/3 +.... + 1/i
 * Write a test program that displays m(i) for i = 1, 2, . . ., 10.
 *
 * @author Harry Dulaney
 */
public class Exercise18_04 {

    public static void main(String[] args) {
        for (int i = 1; i <= 10; i++) {
            System.out.printf("\nm(" + i + ") = %.4f", m(i));
        }

    }

   private static double m(int target) {
        double sum = 1;
        int denominator = 1;
        return m(sum, denominator, target);
    }

   private static double m(double sum, int denominator, int target) {
        if (denominator == target) {
            return sum;
        }
        sum += 1.0 / ++denominator;
        return m(sum, denominator, target);
    }
}
