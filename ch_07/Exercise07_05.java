package ch_07;

import java.util.Scanner;

/**
 * 7.5 (Print distinct numbers) Write a program that reads in ten numbers and
 * displays the number of distinct numbers and the distinct numbers in their
 * input order and separated by exactly one space (i.e., if a number appears
 * multiple times, it is displayed only once). (Hint: Read a number and store
 * it to an array if it is new. If the number is already in the array, ignore it.)
 * After the input, the array contains the distinct numbers.
 */
public class Exercise07_05 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int[] nums = new int[10];

        int checkNum = 0;
        int counter = 0;

        System.out.print("Enter ten integers seperated by spaces: ");

        for (int i = 0; i < 10; i++) {
            checkNum = input.nextInt();
            if (specialNum(nums, checkNum)) {
                nums[counter] = checkNum;
                counter++;
            }
        }

        System.out.println("The count of distinct numbers are " + counter);
        System.out.print("The distinct numbers are");

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0)
                System.out.print(" " + nums[i]);
        }
        System.out.println();
    }

    public static boolean specialNum(int[] a, int number) {
        for (int i = 0; i < a.length; i++) {
            if (a[i] == number)
                return false;
        }
        return true;
    }
}