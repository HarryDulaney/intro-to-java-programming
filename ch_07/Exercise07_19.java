package ch_07;

import java.util.*;

/**
 * **7.19 (Sorted?) Write the following method that returns true if the list is already sorted
 * in increasing order.
 * public static boolean isSorted(int[] list)
 * Write a test program that prompts the user to enter a list and displays whether
 * the list is sorted or not. Here is a sample run. Note that the first number in the
 * input indicates the number of the elements in the list. This number is not part
 * of the list.
 * Enter list: 8 10 1 5 16 61 9 11 1
 * The list is not sorted
 * Enter list: 10 1 1 3 4 4 5 7 9 11 21
 * The list is already sorted
 */
public class Exercise07_19 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        System.out.println("Enter list: ");
        int[] nums = new int[in.nextInt()];

        for (int i = 0; i < nums.length; i++) {
            nums[i] = in.nextInt();
        }

        if (isSorted(nums)) {
            System.out.println("The list is sorted");

        } else {
            System.out.println("The list is not sorted");

        }
    }

    public static boolean isSorted(int[] list) {
        boolean sorted = true;
        for (int i = 1; i < list.length; i++) {
            for (int j = 0; j < list.length - i; j++) {
                if (list[j] > list[j + 1]) {
                    sorted = false;
                    break;
                }

            }
        }
        return sorted;
    }

}