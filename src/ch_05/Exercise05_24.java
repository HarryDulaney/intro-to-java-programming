package ch_05;

import java.util.*;

/**
 * Write a program that compares the results of the summation of the preceding
 * series, computing from left to right and from right to left with n = 50000.
 * *5.24 (Sum a series) Write a program to sum the following series:
 * 1 3
 * +
 * 3 5
 * +
 * 5 7
 * +
 * 7 9
 * +
 * 9
 * 11
 * +
 * 11
 * 13
 * + g +
 * 95
 * 97
 * +
 * 97
 * 99
 */
public class Exercise05_24 {
    public static void main(String[] args) {
        double res = 0.0;
        System.out.println("Cancellation error example calculating from right to left: ");
        for (int i = 1000; i >= 1; i--) {
            res += 1.0 / i;
        }
        System.out.println("Total Sum: " + res);
        double res2 = 0.0;
        System.out.println("Cancellation error example calculating from left to right: ");
        for (int i = 1; i <= 1000; i++) {
            res2 += 1.0 / i;
        }
        System.out.println("Total Sum: " + res2);
        double d = res - res2;
        System.out.println("By going from left to right, we lost accuracy of " + d);
    }
}