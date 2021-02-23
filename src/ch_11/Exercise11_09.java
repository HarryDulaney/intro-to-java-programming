package ch_11;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * *11.9 (Largest rows and columns) Write a program that randomly fills in 0s and 1s
 * into an n-by-n matrix, prints the matrix, and finds the rows and columns with the
 * most 1s. (Hint: Use two ArrayLists to store the row and column indices with
 * the most 1s.) Here is a sample run of the program:
 * Enter the array size n: 4
 * The random array is
 * 0011
 * 0011
 * 1101
 * 1010
 * The largest row index: 2
 * The largest column index: 2, 3
 */
public class Exercise11_09 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.print("Enter the array size n: ");
        int size = in.nextInt();

        int[][] matrix = new int[size][size];
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                matrix[i][j] = (int) (Math.random() * 2);
            }
        }
        in.close();
        ArrayList<Integer> rowSums = new ArrayList<>();
        ArrayList<Integer> columnSums = new ArrayList<>();

        for (int i = 0; i < matrix.length; i++) {
            int sum = 0;
            for (int j = 0; j < matrix[i].length; j++) {
                sum += matrix[i][j];
            }
            rowSums.add(i, sum);
        }

        for (int i = 0; i < matrix.length; i++) {
            int sum = 0;
            for (int j = 0; j < matrix[i].length; j++) {
                sum += matrix[j][i];
            }
            columnSums.add(i, sum);
        }
        Integer maxRowValue = maxValue(rowSums);
        Integer maxColValue = maxValue(columnSums);

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println("\nRow sums: " + rowSums.toString());
        System.out.println("Column sums: " + columnSums.toString());

        System.out.print("The largest row index/es is: ");
        for (Integer i : rowSums) {
            if (i.equals(maxRowValue)) {
                System.out.print(rowSums.indexOf(i) + " ");
            }
        }
        System.out.print("\nThe largest column index is: ");

        for (Integer i : columnSums) {
            if (i.equals(maxColValue)) {
                System.out.print(columnSums.indexOf(i) + " ");
            }
        }


    }

    static Integer maxValue(ArrayList<Integer> nums) {
        Integer max = nums.get(0);
        for (Integer integer : nums) {
            max = Math.max(integer, max);
        }
        return max;
    }

}
