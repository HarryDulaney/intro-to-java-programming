package ch_18;

/**
 * 18.5 (Sum series) Write a recursive method to compute the following series:
 * m(i) = 1/3 + 2/5 + 3/7 + 4/9 + 5/11 + 6/13 + ...... + i/2i + 1
 * <p>
 * Write a test program that displays m(i) for i = 1, 2, . . ., 10.
 *
 * @author Harry D.
 */
public class Exercise18_05 {
    public static void main(String[] args) {
        for (int i = 1; i <= 10; i++) {
            System.out.printf("\nm(" + i + ") = %.4f", m(i));
        }

    }

    private static double m(int target) {
        int numerator = 1;
        double sum = numerator / ((2.0 * numerator) + 1);
        return m(sum, numerator, target);
    }

    private static double m(double sum, int numerator, int target) {
        if (numerator == target) {
            return sum;
        }
        numerator++;
        sum += numerator / ((2.0 * numerator) + 1);

        return m(sum, numerator, target);
    }
}
