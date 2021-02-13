package ch_18;

import java.util.Scanner;

/**
 * *18.13 (Find the largest number in an array) Write a recursive method that returns the
 * largest integer in an array.
 * <p>
 * Write a test program that prompts the user to enter a list of eight integers and displays the largest element.
 */
public class Exercise18_13 {
    static int currIdx = 0;

    public static void main(String[] args) {
        int[] arr = new int[8];
        Scanner in = new Scanner(System.in);
        System.out.println("Enter a list of eight integers: ");
        for (int i = 0; i < 8; i++) {
            arr[i] = in.nextInt();
        }
        in.close();
        System.out.println("The largest integer in the list is " + largestInteger(Integer.MIN_VALUE, arr));


    }

    static int largestInteger(int large, int[] integers) {
        if (currIdx == integers.length) {
            return large;
        }
        large = Math.max(large, integers[currIdx++]);
        return largestInteger(large, integers);
    }
}
