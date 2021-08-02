package ch_07;

import java.util.Arrays;
import java.util.Scanner;

/**
 * *7.20 (Revise selection sort) In Section 7.11, you used selection sort to sort an array.
 * The selection-sort method repeatedly finds the smallest number in the current
 * array and swaps it with the first.
 * <p>
 * Rewrite this program by finding the largest number and swapping it with the last.
 * <p>
 * Write a test program that reads in ten double
 * 3.34 4.33 18.22 111.42 4.98 3.33 90.321 6.6 7.7 8.8
 * numbers, invokes the method, and displays the sorted numbers.
 *
 * @author Harry D.
 */
public class Exercise07_20 {

    public static void main(String[] args) {
        double[] arr = new double[10];

        Scanner in = new Scanner(System.in);
        System.out.println("Enter ten decimal numbers: ");
        for (int i = 0; i < 10; i++) {
            arr[i] = in.nextDouble();
        }
        selectionSort(arr);
        System.out.println("Sorted high to low: ");
        System.out.println(Arrays.toString(arr));


    }

    /**
     * Selection sort implementation using Max value
     */
    public static void selectionSort(double[] list) {
        for (int i = 0; i < list.length - 1; i++) {
            // Find the minimum in the list[i..list.length-1]
            double currentMax = list[i];
            int currentMaxIndex = i;
            for (int j = i + 1; j < list.length; j++) {
                if (currentMax < list[j]) {
                    currentMax = list[j];
                    currentMaxIndex = j;
                }
            }
            // Swap list[i] with list[currentMaxIndex] if necessary
            if (currentMaxIndex != i) {
                list[currentMaxIndex] = list[i];
                list[i] = currentMax;
            }
        }
    }
}
