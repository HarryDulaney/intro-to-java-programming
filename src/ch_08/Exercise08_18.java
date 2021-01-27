package ch_08;

import java.util.*;

/**
 * *8.18 (Shuffle rows) Write a method that shuffles the rows in a two-dimensional int
 * array using the following header:
 * public static void shuffle(int[][] m)
 * Write a test program that shuffles the following matrix:
 * int[][] m = {{1, 2}, {3, 4}, {5, 6}, {7, 8}, {9, 10}};
 */
public class Exercise08_18 {
    public static void main(String[] args) {
        int[][] m = {{1, 2}, {3, 4}, {5, 6}, {7, 8}, {9, 10}};
        for (int i = 0; i < 10; i++) {
            shuffle(m);
        }
        for (int[] i : m) {
            System.out.print(Arrays.toString(i));
            System.out.print(" ");
        }
    }

    public static void shuffle(int[][] m) {

        for (int i = 0, x = 0; i < m.length; i++) {
            for (int j = 0; j < m[i].length; j++) {
                int temp = m[i][j];

                int r1 = randIdx(m.length - 1);
                int r2 = randIdx(m[i].length - 1);
                if (r1 == i || r2 == j) {
                    continue;
                }
                //Swamp
                m[i][j] = m[r1][r2];
                m[r1][r2] = temp;

            }

        }
    }

    static int randIdx(int upperBound) {
        return (int) (Math.random() * upperBound);
    }
}
