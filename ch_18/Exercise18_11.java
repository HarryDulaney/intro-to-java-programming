package ch_18;

import java.util.Scanner;

/**
 * *18.11 (Sum the digits in an integer using recursion) Write a recursive method that
 * computes the sum of the digits in an integer. Use the following method header:
 * public static int sumDigits(long n)
 * For example, sumDigits(234) returns 2 + 3 + 4 = 9.
 * <p>
 * Write a test program that prompts the user to enter an integer and displays its sum.
 * Section 18.5
 */
public class Exercise18_11 {
    static int sum;

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println("Enter an integer: ");
        long num = in.nextInt();
        System.out.println("Sum of the digits in " + num + " is " + sumDigits(num));

    }

    public static int sumDigits(long n) {
        if (n == 0) {
            return sum;
        }
        long i = n % 10;
        sum += i;
        n /= 10;
      return sumDigits(n);
    }
}
