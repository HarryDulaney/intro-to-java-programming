package ch_07;

import java.util.Scanner;

/**
 * *7.30 (Pattern recognition: consecutive four equal numbers) Write the following
 * method that tests whether the array has four consecutive numbers with the same
 * value.
 * public static boolean isConsecutiveFour(int[] values)
 * Write a test program that prompts the user to enter a series of integers and displays if the series contains four consecutive numbers with the same value. Your
 * program should first prompt the user to enter the input size—i.e., the number of
 * values in the series. Here are sample runs:
 * Enter the number of values: 8
 * Enter the values: 3 4 5 5 5 5 4 5
 * The list has consecutive fours
 *
 * @author Harry D.
 */
public class Exercise07_30 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        System.out.print("Enter the number of values: ");
        int len = in.nextInt();
        int[] nums = new int[len];

        System.out.print("Enter the values: ");
        for (int i = 0; i < len; i++) {
            nums[i] = in.nextInt();
        }
        if (isConsecutiveFour(nums)) {
            System.out.println("The list has consecutive fours.");
        } else {
            System.out.println("The list does not have consecutive fours.");
        }
    }

    /**
     * Write the following
     * method that tests whether the array has four consecutive numbers with the same value.
     *
     * @param values the array
     * @return true if four consecutive nums with same value
     */
    public static boolean isConsecutiveFour(int[] values) {
        int lastNum = values[0];
        int count = 1;
        for (int j = 1; j < values.length; j++) {
            if (lastNum == values[j]) {
                count++;
            } else {
                lastNum = values[j];
                count = 1;
            }
            if (count == 4) {
                return true;
            }
        }
        return false;

    }

}
