package ch_08;

import java.util.Scanner;

/**
 * *8.35 (Largest block) Given a square matrix with the elements 0 or 1, write a program
 * to find a maximum square submatrix whose elements are all 1s. Your program
 * should prompt the user to enter the number of rows in the matrix. The program
 * then displays the location of the first element in the maximum square submatrix
 * and the number of the rows in the submatrix.
 * <p>
 * Your program should implement and use the following method to find the maximum
 * square submatrix:
 * public static int[] findLargestBlock(int[][] m)
 * The return value is an array that consists of three values. The first two values are
 * the row and column indices for the first element in the submatrix, and the third
 * value is the number of the rows in the submatrix.
 */
public class Exercise08_35 {
    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);
        System.out.print("Enter the number of rows in the matrix: ");
        final int numRows = input.nextInt();

        int[][] userMatrix = new int[numRows][numRows];
        System.out.println("Enter the matrix row by row (0 or 1 values only): ");

        for (int i = 0; i < userMatrix.length; i++) {
            for (int j = 0; j < userMatrix[i].length; j++) {
                userMatrix[i][j] = input.nextInt();
            }
        }
        int[] largestBlock = findLargestBlock(userMatrix);

        System.out.printf("The maximum submatrix square is at (%d,%d) and it has %d number of rows."
                , largestBlock[0], largestBlock[1], largestBlock[2]);
    }

    private static int[] findLargestBlock(int[][] m) {
        int i, j;
        final int rowLength = m.length;
        final int columnLength = m[0].length;
        int[][] easyCopy = new int[rowLength][columnLength];

        int easyCopyMax, maxI, maxJ;
        for (i = 0; i < rowLength; i++)
            easyCopy[i][0] = m[i][0];
        for (j = 0; j < columnLength; j++)
            easyCopy[0][j] = m[0][j];

        for (i = 1; i < rowLength; i++) {
            for (j = 1; j < columnLength; j++) {
                if (m[i][j] == 1) {
                    easyCopy[i][j] = Math.min(easyCopy[i][j - 1],
                            Math.min(easyCopy[i - 1][j], easyCopy[i - 1][j - 1])) + 1;
                } else {
                    easyCopy[i][j] = 0;
                }
            }
        }

        easyCopyMax = easyCopy[0][0];
        maxI = 0;
        maxJ = 0;
        for (i = 0; i < rowLength; i++) {
            for (j = 0; j < columnLength; j++) {
                if (easyCopyMax < easyCopy[i][j]) {
                    easyCopyMax = easyCopy[i][j];
                    maxI = i;
                    maxJ = j;
                }
            }
        }
        int[] result = new int[3];
        int countRow = 0;
        for (i = maxI; i > maxI - easyCopyMax; i--) {
            countRow++;
            for (j = maxJ; j > maxJ - easyCopyMax; j--) {
                System.out.print(m[i][j] + " ");
                result[0] = i;
                result[1] = j;
            }
            System.out.println();
        }
        result[2] = countRow;
        return result;
    }

}
