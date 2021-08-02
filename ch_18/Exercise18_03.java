package ch_18;

import java.util.Scanner;

/**
 * *18.3 (Compute greatest common divisor using recursion) The gcd(m, n) can also
 * be defined recursively as follows:
 * ■ If m % n is 0, gcd(m, n) is n.
 * ■ Otherwise, gcd(m, n) is gcd(n, m % n).
 * Write a recursive method to find the GCD. Write a test program that prompts the
 * user to enter two integers and displays their GCD.
 *
 * @author Harry D.
 */
public class Exercise18_03 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        System.out.println("Enter two integers: ");
        int m = in.nextInt();
        int n = in.nextInt();

        System.out.println("The GCD of " + m + " and " + n + " is " + gcd(m, n));

    }

    static int gcd(int m, int n) {
        if (m % n == 0) {
            return n;
        }
        return gcd(n, m % n);
    }
}
