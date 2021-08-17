package ch_19;

import java.util.Arrays;

/**
 * 19.7 (Generic binary search) Implement the following method using binary search.
 * public static <E extends Comparable<E>> int binarySearch(E[] list, E key)
 */
public class Exercise19_07 {
    public static void main(String[] args) {
        Double searchKey = 111.11;
        Double[] values = new Double[]{4400.1, 1203.3, 3100.0, 18700.8, 4100.6, 111.11, 2222.21, 4529.21};

        System.out.println("Generic Binary Search method found the search key value: " + searchKey + " at index: " + binarySearch(values,
                searchKey) + " in the above array.");

    }

    public static <E extends Comparable<E>> int binarySearch(E[] list, E key) {
        System.out.println("Sorting the array to ensure binarySearch is supported: ");
        Arrays.sort(list);
        System.out.println(Arrays.toString(list));
        int lowIdx = 0; // First element in the array
        int highIdx = list.length - 1; // Last element in the array
        while (highIdx >= lowIdx) {
            int midIdx = (lowIdx + highIdx) / 2;
            int compare = key.compareTo(list[midIdx]); // Compare key to value at midIdx
            if (compare < 0) { // Key is less than list[midIdx]
                highIdx = midIdx - 1; // Value can only be to the left of list[midIdx]
            } else if (compare == 0) { // Key equals list[midIdx]
                return midIdx; // Return the index of matched value
            } else { // Key is greater than list[midIdx]
                lowIdx = midIdx + 1; // Value can only be to the right of list[midIdx]
            }
        }
        return -1; // No matching value found in list
    }
}
