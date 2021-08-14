package ch_19;

import java.util.Arrays;

/**
 * 19.4 (Generic linear search) Implement the following generic method for linear search.
 * <p>
 * {@code public static <E extends Comparable<E>>int linearSearch(E[] list, E key) }
 */
public class Exercise19_04 {
    public static void main(String[] args) {
        Double searchKey = 100.8;
        Double[] values = new Double[]{100.1, 100.3, 100.0, 100.8, 100.6};
        System.out.println("Generic LinearSearch returned index: " + linearSearch(values,
                searchKey) + ". When search key is " + searchKey + " and an Array of Double values is: \n" + Arrays.toString(values));
    }


    public static <E extends Comparable<E>> int linearSearch(E[] list, E key) {
        for (int i = 0; i < list.length; i++) {
            if (list[i].compareTo(key) == 0) {
                return i;
            }

        }
        return -1;

    }
}
