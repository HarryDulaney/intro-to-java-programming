package ch_18;

/**
 * *18.6 (Sum series) Write a recursive method to compute the following series:
 * m(i) = 1/2 + 2/3 + .... + i/i + 1
 * Write a test program that displays m(i) for i = 1, 2, . . ., 10.
 *
 * @author Harry Dulaney
 */
public class Exercise18_06 {
    public static void main(String[] args) {
        for (int i = 1; i <= 10; i++) {
            System.out.printf("\nm(" + i + ") = %.4f", m(i));
        }

    }

    private static double m(int i) {
        double x = 1;
        double sum = x / (x + 1);
        return m(sum, x, i);

    }

    private static double m(double sum, double x, int i) {
        if (x == i) {
            return sum;
        }
        x += 1;
        sum += x / (x + 1);
        return m(sum, x, i);

    }
}
