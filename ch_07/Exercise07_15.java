package ch_07;

import java.util.Arrays;
import java.util.Scanner;

/**
 * 7.15 (Eliminate duplicates) Write a method that returns
 * a new array by eliminating
 * the duplicate values in the
 * array using the following method header:
 * Write a test program that reads in ten integers, invokes the method,
 * and displays the numbers separated by exactly one space.
 */
public class Exercise07_15 {

    public static int[] eliminateDuplicates(int[] list) {
        int[] list2 = new int[list.length];
        int x = 0;

        for (int i = 0; i < list.length; i++) {
            boolean dup = false;

            for (int k = 0; k < list.length; k++) {
                if (list2[k] == list[i]) {
                    dup = true;
                }
            }
            if (!dup) {

                list2[x++] = list[i];
            }
        }

        int[] finishedArray = new int[x];
        for (int i = 0; i < x; i++) {
            finishedArray[i] = list2[i];
        }

        return finishedArray;
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int[] list = new int[10];

        System.out.println("Enter ten integers: ");
        for (int i = 0; i < 10; i++) {
            list[i] = input.nextInt();

        }

        Arrays.sort(list);
        int[] finishedArray = eliminateDuplicates(list);

        System.out.println("The number of distinct integers is: " + finishedArray.length);
        System.out.print("The distinct integers are: ");

        for (int i = 0; i < finishedArray.length; i++) {
            System.out.print(finishedArray[i] + " ");
        }
        input.close();
    }
}
