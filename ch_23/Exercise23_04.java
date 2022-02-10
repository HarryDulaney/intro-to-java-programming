package ch_23;

import java.util.Arrays;

/**
 * 23.4 (Improve quick sort) The quick sort algorithm presented in the book selects the
 * first element in the list as the pivot. Revise it by selecting the median among the
 * first, middle, and last elements in the list.
 */
public class Exercise23_04 {
    public static void main(String[] args) {
        int[] list = {2, 3, 2, 5, 6, 1, -2, 3, 14, 12};
        quickSort(list);
        System.out.println("Sorted List: \n" + Arrays.toString(list));
    }

    public static void quickSort(int[] list, int first, int last) {
        if (last > first) {
            int pivotIndex = partition(list, first, last);
            quickSort(list, first, pivotIndex - 1);
            quickSort(list, pivotIndex + 1, last);
        }
    }

    public static void quickSort(int[] list) {
        quickSort(list, 0, list.length - 1);
    }

    /**
     * Partition the array list[first..last]
     */
    public static int partition(int[] list, int first, int last) {
        /* Exercise 23_04 */
        int pivotIdx = findMedian(list, first, last);
        int pivot = list[pivotIdx];
        int low = first; // Index for forward search
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
            list[pivotIdx] = list[high];
            list[high] = pivot;
            return high;
        } else {
            return pivotIdx;
        }
    }

    /**
     * Exercise 23.04 solution
     *
     * @param list  current list
     * @param first current left index
     * @param last  current right index
     * @return index of the median between first, last, and mid index values
     */
    static int findMedian(int[] list, int first, int last) {
        int midIdx = (first + last) / 2;
        int firstVal = list[first];
        int lastVal = list[last];
        int midVal = list[midIdx];
        int max = Math.max(Math.max(firstVal, lastVal), midVal);
        int min = Math.min(Math.min(firstVal, lastVal), midVal);
        if (midVal != min && midVal != max) return midIdx;
        else if (lastVal != min && lastVal != max) return last;
        else return first;

    }
}


