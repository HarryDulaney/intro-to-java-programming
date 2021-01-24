package ch_07;

import java.util.*;

/**
 * **7.31 (Merge two sorted lists) Write the following method that merges two sorted lists
 * into a new sorted list.
 * public static int[] merge(int[] list1, int[] list2)
 * Implement the method in a way that takes at most list1.length + list2.
 * length comparisons.
 * <p>
 * Write a test program that prompts the user to enter two
 * sorted lists and displays the merged list. Here is a sample run. Note that the first
 * number in the input indicates the number of the elements in the list. This number
 * is not part of the list.
 * Enter list1: 5 1 5 16 61 111
 * Enter list2: 4 2 4 5 6
 * The merged list is 1 2 4 5 5 6 16 61 111
 */
public class Exercise07_31 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println("Enter list1: ");
        int n1 = in.nextInt();
        int[] l1 = new int[n1];
        int i = 0;
        while (i < n1) {
            l1[i++] = in.nextInt();
        }

        System.out.println("Enter list2: ");
        int n2 = in.nextInt();
        int[] l2 = new int[n2];
        i = 0;
        while (i < n2) {
            l2[i++] = in.nextInt();
        }


        System.out.println(Arrays.toString(merge(l1, l2)));

    }

    public static int[] merge(int[] list1, int[] list2) {
        int len = list1.length + list2.length;
        int startL2 = list1.length;
        int[] result = new int[len];
        System.arraycopy(list1, 0, result, 0, list1.length);
        System.arraycopy(list2, 0, result, startL2, list2.length);

        Arrays.sort(result);
        return result;

    }
}