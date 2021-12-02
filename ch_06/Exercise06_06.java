package ch_06;

import java.util.*;

/**
 * 6.6 (Display patterns) Write a method to display a pattern as follows:
 * 1
 * 2 1
 * 3 2 1
 * ...
 * n n-1 ... 3 2 1
 * The method header is
 * public static void displayPattern(int n)
 */
public class Exercise06_06 {
    public static void displayPattern(int n) {
        int pad = n - 1; //Track padding to loop for each line
        for (int r = 1; r <= n; r++) { //Main loop

            for (int p = 0; p < pad; p++) {
                System.out.print("  ");
            }

            for (int i = r; i > 0; i--) {
                System.out.print(i + " ");
            }
            System.out.println();
            pad--; // decrease padding as we increase r in for loop
        }

    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Enter the number of rows to print: ");
        int userRows = input.nextInt();

        displayPattern(userRows);

    }
}