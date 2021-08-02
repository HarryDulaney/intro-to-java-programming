package ch_07;

import java.util.Arrays;
import java.util.Scanner;

/**
 * **7.32 (Partition of a list) Write the following method that partitions the list using the
 * first element, called a pivot.
 * public static int partition(int[] list)
 * <p>
 * After the partition, the elements in the list are rearranged so that all the elements
 * before the pivot are less than or equal to the pivot and the elements after the pivot
 * are greater than the pivot. The method returns the index where the pivot is located
 * in the new list. For example, suppose the list is {5, 2, 9, 3, 6, 8}. After the partition,
 * the list becomes {3, 2, 5, 9, 6, 8}. Implement the method in a way that takes
 * at most list.length comparisons.
 * <p>
 * Write a test program that prompts the user
 * to enter a list and displays the list after the partition. Here is a sample run. Note
 * that the first number in the input indicates the number of the elements in the list.
 * This number is not part of the list.
 * <p>
 * Enter list: 8 10 1 5 16 61 9 11 1
 * After the partition, the list is 9 1 5 1 10 61 11 16
 *
 */
public class Exercise07_32 {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.print("Enter list: ");
        int length = in.nextInt();
        int[] list = new int[length];

        for (int i = 0; i < list.length; i++) {
            list[i] = in.nextInt();

        }
        int indexOfPivot = partition(list);
        System.out.println("After the partition the list is ");
        for (int j : list) {
            System.out.print(j + " ");
        }
        System.out.println("Pivot point is " + indexOfPivot);


    }

    public static int partition(int[] list) {
        int pivotPoint = 0;
        int pivot = list[0];

        while (true) {
            boolean partitioned = true;
            for (int j = 0; j < list.length; j++) {
                if (j == pivotPoint) {
                    continue;
                }

                if (list[j] < pivot) {
                    if (j > pivotPoint) {
                        partitioned = false;
                        int tmp = list[j];
                        list[j] = pivot;
                        list[pivotPoint] = tmp;
                        pivotPoint = j;
                    }

                } else if (list[j] > pivot) {
                    if (j < pivotPoint) {
                        partitioned = false;
                        int tmp = list[j];
                        list[j] = pivot;
                        list[pivotPoint] = tmp;
                        pivotPoint = j;
                    }

                }

            }
            if (partitioned) break;
        }
        return pivotPoint;

    }

}

