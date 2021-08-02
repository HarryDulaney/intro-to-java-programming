package ch_09.exercise09_13;

import java.util.Scanner;

/**
 * <p>
 * Write a test program that prompts
 * the user to enter a two-dimensional array and displays the location of the largest
 * element in the array. Here is a sample run:
 * <p>
 * * Enter the number of rows and columns in the array: 3 4
 * * Enter the array:
 * * 23.5 35 2 10
 * * 4.5 3 45 3.5
 * * 35 44 5.5 9.6
 * * The location of the largest element is 45 at (1, 2)
 */
public class Exercise09_13 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.print("Enter the number of rows and columns in the array: ");

        int numRow = in.nextInt();
        int numCol = in.nextInt();
        double[][] numbers = new double[numRow][numCol];

        System.out.println("Enter the array: ");

        for (int r = 0; r < numbers.length; r++) {
            for (int c = 0; c < numbers[r].length; c++) {
                numbers[r][c] = in.nextDouble();
            }
        }
        Location location = Location.locateLargest(numbers);

        System.out.printf("The location of the largest element is: %.2f at (%d, %d)", location.maxValue, location.row,
                location.column
        );


    }
}
