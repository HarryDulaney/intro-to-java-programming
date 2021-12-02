package ch_06;

import java.util.Scanner;

/**
 * *6.17 (Display matrix of 0s and 1s) Write a method that displays an n-by-n matrix using
 * the following header:
 * public static void printMatrix(int n)
 * Each element is 0 or 1, which is generated randomly.
 * <p>
 * Write a test program that
 * prompts the user to enter n and displays an n-by-n matrix. Here is a sample run:
 * * Enter n: 3
 * * 0 1 0
 * * 0 0 0
 * * 1 1 1
 *
 * @author Harry D.
 */
public class Exercise06_17 {
    public static void printMatrix(int n) {
        if (!(n < 1000)) {
            System.out.println(n + " is too large and may overload your computer....");
            return;
        }
        for (int i = n; i > 0; i--) {
            for (int j = n; j > 0; j--) {
                System.out.print((int) (Math.random() * 2) + " ");
            }
            System.out.println();

        }
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println("Enter n: ");
        int n = in.nextInt();
        printMatrix(n);
        in.close();

    }
}
