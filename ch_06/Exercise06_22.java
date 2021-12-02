package ch_06;

/**
 * **6.22 (Math: approximate the square root) There are several techniques for implementing the sqrt method in the Math class.
 * One such technique is known as the Babylonian method. It approximates the square root of a number, n, by repeatedly
 * performing a calculation using the following formula:
 * nextGuess = (lastGuess + n / lastGuess) / 2
 * <p>
 * When nextGuess and lastGuess are almost identical, nextGuess is the
 * approximated square root.
 * <p>
 * The initial guess can be any positive value (e.g., 1).
 * This value will be the starting value for lastGuess. If the difference between
 * nextGuess and lastGuess is less than a very small number, such as 0.0001,
 * you can claim that nextGuess is the approximated square root of n.
 * If not, nextGuess becomes lastGuess and the approximation process continues.
 * <p>
 * Implement the following method that returns the square root of n.
 * public static double sqrt(long n)
 */
public class Exercise06_22 {
    public static void main(String[] args) {
        for (int i = 10; i < 100; i += 10) { //Exercise09_09
            System.out.println("The result of the Babylonian sqrt method for: " + i + " = " + sqrt(i));
            System.out.println("The result of Math.sqrt(i) method for: " + i + " = " + Math.sqrt(i));
        }
    }

    public static double sqrt(long n) {
        double lastGuess = 2;
        double nextGuess = (lastGuess + n / lastGuess) / 2;

        while (!diff(nextGuess, lastGuess)) {
            lastGuess = nextGuess;
            nextGuess = (lastGuess + n / lastGuess) / 2;
        }
        return nextGuess;

    }

    static boolean diff(double a, double b) {
        return Math.abs(a - b) < 0.0001; // If the difference between nextGuess and lastGuess is less than 0.0001.
    }
}
