package ch_08;

import java.util.*;

/**
 * **8.19 (Pattern recognition: four consecutive equal numbers) Write the following
 * method that tests whether a two-dimensional array has four consecutive numbers
 * of the same value, either horizontally, vertically, or diagonally.
 * public static boolean isConsecutiveFour(int[][] values)
 * <p>
 * Programming
 * Write a test program that prompts the user to enter the number of rows and columns of a two-dimensional array and then the values in the array and displays
 * true if the array contains four consecutive numbers with the same value. Otherwise, display false. Here are some examples of the true cases:
 * <br>
 * 0 1 0 3 1 6 1    *    0 1 0 3 1 6 1    *   0 1 0 3 1 6 1    *   0 1 0 3 1 6 1
 * 0 1 6 8 6 0 1    *    0 1 6 8 6 0 1    *   0 1 6 8 6 0 1    *   0 1 6 8 6 0 1
 * 9 6 2 1 8 2 9    *    5 6 2 1 8 2 9    *   5 5 2 1 8 2 9    *   5 6 2 1 6 2 9
 * 6 9 6 1 1 9 1    *    6 5 6 1 1 9 1    *   6 5 6 1 1 9 1    *   6 5 6 6 1 9 1
 * 1 3 9 1 4 0 7    *    1 3 6 1 4 0 7    *   1 5 6 1 4 0 7    *   1 3 6 1 4 0 7
 * 3 3 3 9 4 0 7    *    3 3 3 3 4 0 7    *   3 5 3 3 4 0 7    *   3 6 3 3 4 0 7
 * <p>
 */
public class E0819 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println("Enter the number of rows and columns of a two-dimensional array and then the values in " +
                "the array: ");
    }

    public static boolean isConsecutiveFour(int[][] values) {
        return true;
    }

}