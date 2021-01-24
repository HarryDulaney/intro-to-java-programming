package ch_08;

import java.util.*;

/**
 * **8.14 (Explore matrix) Write a program that prompts the user to enter the length of a
 * square matrix, randomly fills in 0s and 1s into the matrix, prints the matrix, and
 * finds the rows, columns, and diagonals with all 0s or 1s. Here is a sample run of
 * the program:
 * <p>
 * Enter the size for the matrix: 4
 * 0111
 * 0000
 * 0100
 * 1111
 * All 0s on row 1
 * All 1s on row 3
 * No same numbers on a column
 * No same numbers on the major diagonal
 * No same numbers on the sub-diagonal
 */
public class Exercise08_14 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println("Enter the size for the the matrix: ");
        int size = in.nextInt();
        int[][] matrix = new int[size][size];

        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                matrix[i][j] = (int) (0.5 + Math.random());
            }
        }
        for (int[] array : matrix) {
            System.out.println(Arrays.toString(array));
        }

        //Check rows
        int[] row = checkRows(matrix);
        //Check columns
        int[] column = checkColumns(matrix);


        if (row != null) {
            System.out.println("All " + row[0] + " on " + "row " + row[1]);
        } else {
            System.out.println("No same numbers on a row");
        }

        if (column != null) {
            System.out.println("All " + column[0] + " on " + "column " + column[1]);
        } else {
            System.out.println("No same numbers on a column");
        }


    }

    static int[] checkColumns(int[][] matrix) {
        for (int checkNum = 0; checkNum <= 1; checkNum++) {
            for (int i = 0; i < matrix.length; i++) {
                if (checkColumn(matrix, i, checkNum)) {
                    return new int[]{checkNum, i};
                }
            }
        }
        return null;
    }

    static boolean checkColumn(int[][] matrix, int column, int num) {
        for (int i = 0; i < matrix.length; i++) {
            if (matrix[i][column] != num) {
                return false;
            }
        }
        return true;
    }

    static int[] checkRows(int[][] matrix) {
        for (int i = 0; i < matrix.length; i++) {
            int rowCheck = matrix[i][0];
            COLUMN:
            for (int j = 0; j < matrix[i].length; j++) {
                if (matrix[i][j] != rowCheck) {
                    break COLUMN;
                } else if (j == matrix[i].length - 1) {
                    return new int[]{rowCheck, i};
                }
            }
        }
        return null;
    }
}