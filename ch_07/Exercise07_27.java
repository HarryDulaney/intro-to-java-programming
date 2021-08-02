package ch_07;

import java.util.Arrays;
import java.util.Scanner;

/**
 * 7.27 (Identical arrays) The arrays list1 and list2 are identical if they have the
 * same contents.
 * <p>
 * Write a method that returns true if list1 and list2 are identical, using the following header:
 * public static boolean equals(int[] list1, int[] list2)
 * <p>
 * Write a test program that prompts the user to enter two lists of integers and displays whether the two are identical.
 * <p>
 * Here are the sample runs. Note that the first
 * number in the input indicates the number of the elements in the list. This number
 * is not part of the list.
 * Enter list1: 5 2 5 6 6 1
 * Enter list2: 5 5 2 6 1 6
 * Two lists are identical
 */
public class Exercise07_27 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.print("Enter list 1: ");
        int l1Size = in.nextInt();

        int[] l1 = new int[l1Size];
        for (int i = 0; i < l1.length; i++) {
            l1[i] = in.nextInt();
        }

        System.out.print("\nEnter list 2: ");
        int l2Size = in.nextInt();
        int[] l2 = new int[l2Size];

        for (int i = 0; i < l2.length; i++) {
            l2[i] = in.nextInt();
        }

        if (equals(l1, l2)) {
            System.out.println("The Two lists are identical.");
        } else {
            System.out.println("The two lists are not identical.");
        }
        in.close();
    }

    public static boolean equals(int[] list1, int[] list2) {
        Arrays.sort(list1);
        Arrays.sort(list2);

        if (list1.length != list2.length) {
            return false;
        }
        for (int i = 0; i < list1.length; i++) {
            if (list1[i] != list2[i]) {
                return false;
            }
        }
        return true;
    }
}
