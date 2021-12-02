package ch_07;

import java.util.*;

/**
 * 7.10 (Find the index of the smallest element) Write a method that returns the index of
 * the smallest element in an array of integers. If the number of such elements is
 * greater than 1, return the smallest index. Use the following header:
 * public static int indexOfSmallestElement(double[] array)
 * Write a test program that prompts the user to enter ten numbers, invokes this
 * method to return the index of the smallest element, and displays the index.
 *
 * @author Harry Dulaney
 */
public class Exercise07_10 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println("Enter ten numbers: ");

        double[] nums = new double[10];
        for (int i = 0; i < nums.length; i++) {
            nums[i] = in.nextDouble();
        }
        int x = indexOfSmallestElement(nums);
        System.out.println("Index of the smallest element is " + x + " with a value of " + nums[x]);
    }

    public static int indexOfSmallestElement(double[] array) {

        double smallest = Double.MAX_VALUE;
        int smallIdx = 0;
        for (int i = 0; i < array.length; i++) {
            if (smallest > array[i]) {
                smallest = array[i];
                smallIdx = i;
            }

        }
        return smallIdx;
    }
}