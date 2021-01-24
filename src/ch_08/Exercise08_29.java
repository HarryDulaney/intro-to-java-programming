package ch_08;

import java.util.*;

/**
 * 8.29 (Identical arrays) The two-dimensional arrays m1 and m2 are identical if they
 * have the same contents. Write a method that returns true if m1 and m2 are identical, using the following header:
 * public static boolean equals(int[][] m1, int[][] m2)
 * <p>
 * <p>
 * Write a test program that prompts the user to enter two 3 * 3 arrays of integers
 * and displays whether the two are identical. Here are the sample runs.
 * Enter list1: 51 5 22 6 1 4 24 54 6
 * Enter list2: 51 22 25 6 1 4 24 54 6
 * The two arrays are not identical
 * Enter list1: 51 25 22 6 1 4 24 54 6
 * Enter list2: 51 22 25 6 1 4 24 54 6
 * The two arrays are identical
 */
public class Exercise08_29 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int[][] one = new int[3][3];
        System.out.print("Enter list1: ");
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                one[i][j] = in.nextInt();
            }
        }
        int[][] two = new int[3][3];
        System.out.print("\nEnter list2:  ");
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                two[i][j] = in.nextInt();
            }
        }
        if (equals(one, two)) {
            System.out.println("The arrays are identical.");
        } else {
            System.out.println("The arrays are not identical.");
        }
    }

    public static boolean equals(int[][] m1, int[][] m2) {

        for (int i = 0; i < m1.length; i++) {
            for (int j = 0; j < m1[i].length; j++) {
                if (m1[i][j] != m2[i][j]) {
                    return false;
                }
            }
        }
        return true;
    }

}