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
 *
 * @author Harry D.
 */
public class Exercise08_19 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println("Enter the number of rows and columns of a two-dimensional array: ");
        int numRows = in.nextInt();
        int numColumns = in.nextInt();
        int[][] values = new int[numRows][numColumns];
        System.out.println("Enter the values: ");
        for (int i = 0; i < values.length; i++) {
            for (int j = 0; j < values[i].length; j++) {
                values[i][j] = in.nextInt();
            }
        }

        System.out.println("Are there four consecutive numbers?");
        System.out.println(isConsecutiveFour(values));
        in.close();
    }

    public static boolean isConsecutiveFour(int[][] values) {

        int count = 0;
        int lastVal = 0;
        /* Check rows */
        for (int r = 0; r < values.length; r++) {
            count = 0;
            for (int c = 0; c < values[r].length; c++) {
                int val = values[r][c];
                if (val == lastVal) {
                    count++;
                } else {
                    count = 1;
                }
                if (count == 4) {
                    return true;
                }

            }
        }
        lastVal = 0;
        /* Check Columns */
        for (int c = 0; c < values[0].length; c++) {
            count = 0;
            for (int r = 0; r < values.length; r++) {
                int val = values[r][c];
                if (val == lastVal) {
                    count++;
                } else {
                    count = 1;
                }
                if (count == 4) {
                    return true;
                }

            }
        }

        /* Check Diagonals */
        for (int r = 0; r < values.length; r++) {
            for (int c = 0; c < values[r].length; c++) {
                int val = values[r][c];
                count = 1;
                /* Check down and right diagonal */
                for (int d = 1; (r + d) < values.length && (c + d) < values[r].length; d++) {
                    if (values[r + d][c + d] == val) {
                        count++;
                    } else {
                        count = 1;
                        break;
                    }
                    if (count == 4) return true;

                }

                /* Check up and right diagonal */
                for (int d = 1; (r - d) >= 0 && (c + d) < values[r].length; d++) {
                    if (values[r - d][c + d] == val) {
                        count++;
                    } else {
                        count = 1;
                        break;
                    }
                    if (count == 4) return true;
                }

                /* Check down and left diagonal */
                for (int d = 1; (r + d) < values.length && (c - d) >= 0; d++) {
                    if (values[r + d][c - d] == val) {
                        count++;
                    } else {
                        count = 1;
                        break;
                    }
                    if (count == 4) return true;

                }

                /* Check up and left diagonal */
                for (int d = 1; (r - d) >= 0 && (c - d) >= 0; d++) {
                    if (values[r - d][c - d] == val) {
                        count++;
                    } else {
                        count = 1;
                        break;
                    }
                    if (count == 4) return true;

                }
            }

        }
        return false;
    }
}