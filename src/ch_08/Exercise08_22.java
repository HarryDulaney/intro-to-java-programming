package ch_08;

import java.util.*;

/**
 * *8.22 (Even number of 1s) Write a program that generates a 6-by-6 two-dimensional
 * matrix filled with 0s and 1s, displays the matrix, and checks if every row and
 * every column have an even number of 1s.
 *
 * @author Harry D.
 */
public class Exercise08_22 {
    public static void main(String[] args) {
        int[][] a = new int[6][6];
        fillZeroAndOnes(a);
        //Rows check
        for (int j = 0; j < a.length; j++) {
            int numOnes = 0;
            for (int i : a[j]) {
                if (i == 1) numOnes++;
            }
            System.out.print("Row # " + (j + 1) + " ");
            if (numOnes % 2 == 0 && numOnes != 0) {
                System.out.print(" has an even number of ones. ");
            }
            System.out.println(Arrays.toString(a[j]));
        }
        int [] colNums = new int[6];
        //Columns check
        for (int y = 0; y < 6; y++) {
            int numOnes = 0;
            for (int x = 0; x < 6; x++) {
                colNums[x] = a[x][y];
                if (a[x][y] == 1) numOnes++;
            }
            System.out.print("Column # " + (y + 1) + " ");
            if (numOnes % 2 == 0 && numOnes != 0) {
                System.out.print("has an even number of ones. ");
            }
            System.out.println(Arrays.toString(colNums));
        }
    }

    static void fillZeroAndOnes(int[][] arr) {
        for (int i = 0; i < arr.length; i += getRandom()) {
            for (int j = 0; j < arr[i].length; j += getRandom()) {
                arr[i][j] = 1;
            }
        }
    }

    static int getRandom() {
        return (int) (0.5 + Math.random() * 3);
    }
}