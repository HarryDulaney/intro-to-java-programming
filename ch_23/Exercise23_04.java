package ch_23;

import java.util.Arrays;

/**
 * 23.4 (Improve quick sort) The quick sort algorithm presented in the book selects the
 * first element in the list as the pivot. Revise it by selecting the median among the
 * first, middle, and last elements in the list.
 */
public class Exercise23_04 {
    public static void quickSort(int[] list) {
        /* Exercise 23.4 */
        int medianIdx = indexOfMedian(list);
        quickSort(list, medianIdx, list.length - 1);
    }

    public static void quickSort(int[] list, int first, int last) {
        if (last > first) {
            int pivotIndex = partition(list, first, last);
            quickSort(list, first, pivotIndex - 1);
            quickSort(list, pivotIndex + 1, last);
        }
    }

    /**
     * Partition the array list[first..last]
     */
    public static int partition(int[] list, int first, int last) {
        int pivot = list[first]; // Choose the first element as the pivot
        int low = first + 1; // Index for forward search
        int high = last; // Index for backward search

        while (high > low) {
            // Search forward from left
            while (low <= high && list[low] <= pivot)
                low++;

            // Search backward from right
            while (low <= high && list[high] > pivot)
                high--;

            // Swap two elements in the list
            if (high > low) {
                int temp = list[high];
                list[high] = list[low];
                list[low] = temp;
            }
        }

        while (high > first && list[high] >= pivot)
            high--;

        // Swap pivot with list[high]
        if (pivot > list[high]) {
            list[first] = list[high];
            list[high] = pivot;
            return high;
        } else {
            return first;
        }
    }

    /**
     *
     * @param list int array to find median of first, middle and last nums
     * @return the index of the median value
     */
    static int indexOfMedian(int[] list) {
        int[] temp = {list[0], list[list.length / 2], list[list.length - 1]};
        Arrays.sort(temp);
        if (list[0] == temp[1]) {
            return 0;
        }
        else if (list[list.length / 2] == temp[1]) {
            return list.length / 2;
        }

        return list.length - 1;
    }

    /**
     * A test method
     */
    public static void main(String[] args) {
        int[] list = {2, 3, 2, 5, 6, 1, -2, 3, 14, 12};
        quickSort(list);
        for (int i = 0; i < list.length; i++)
            System.out.print(list[i] + " ");
    }
}


