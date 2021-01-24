package ch_05;

import java.util.*;

/**
 * **5.19 (Display numbers in a pyramid pattern) Write a nested for loop that prints the
 * following output:
 *
 */
public class Exercise05_19 {
    public static void main(String[] args) {

        int a = 0,
                z = 7;
        for (int i = 1; i <= 128; i += i) {
            for (int s = 0; s < z; s++) {
                System.out.print("    ");
            }
            for (int j = 1; j <= i; j += j) {
                System.out.printf("%4d", (j));
            }
            for (int x = a; x > 0; x /= 2) {
                System.out.printf("%4d", (x));
            }
            a = i;
            --z;
            System.out.println();
        }
    }
}