package ch_08;

import java.util.*;

/**
 * * 8.23 (Game: find the flipped cell) Suppose you are given a 6-by-6 matrix filled with
 * 0s and 1s.
 * <p>
 * All rows and all columns have an even number of 1s. Let the user flip
 * one cell (i.e., flip from 1 to 0 or from 0 to 1) and write a program to find which
 * cell was flipped. Your program should prompt the user to enter a 6-by-6 array
 * with 0s and 1s and find the first row r and first column c where the even number
 * of the 1s property is violated (i.e., the number of 1s is not even). The flipped cell
 * is at (r, c). Here is a sample run:
 * Enter a 6-by-6 matrix row by row:
 * 1 1 1 0 1 1
 * 1 1 1 1 0 0
 * 0 1 0 1 1 1
 * 1 1 1 1 1 1
 * 0 1 1 1 1 0
 * 1 0 0 0 0 1
 * The flipped cell is at (0, 1)
 */
public class Exercise08_23 {
    public static void main(String[] args) {
        int[][] test = new int[6][6];

        Scanner in = new Scanner(System.in);
        System.out.println("Enter a 6 x 6 matrix row by row: ");

        int invalidRow = -1; //Initialize

        for (int i = 0; i < 6; i++) {
            int rowCountOnes = 0;
            for (int j = 0; j < 6; j++) {
                int n = in.nextInt();
                if (n == 1) {
                    rowCountOnes++;
                }
                test[i][j] = n;
            }
            if (rowCountOnes % 2 != 0) {
                invalidRow = i;
            }
        }
        int invalidCol = evalColumns(test);
        System.out.println("The flipped cell is at (" + invalidRow + ", " + invalidCol + ")");
        in.close();
    }

    static int evalColumns(int[][] array) {
        int invalidColumn = -1;
        for (int i = 0; i < 6; i++) {
            int colCount = 0;
            for (int j = 0; j < 6; j++) {
                if (array[j][i] == 1) {
                    colCount++;
                }

            }
            if (colCount % 2 != 0) {
                invalidColumn = i;
            }
        }
        return invalidColumn;
    }

}