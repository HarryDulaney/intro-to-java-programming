package ch_23;

import java.util.Arrays;
import java.util.Comparator;

/**
 * 23.2 (Generic merge sort) Write the following two generic methods using merge sort.
 * The first method sorts the elements using the Comparable interface and the
 * second uses the Comparator interface.
 * public static <E extends Comparable<E>>
 * void mergeSort(E[] list)
 * public static <E> void mergeSort(E[] list,
 * Comparator<? super E> comparator)
 */
public class Exercise23_02 {
    public static void main(String[] args) {
        Integer[] arr = new Integer[]{23, 25, 7, 14, 85, 65};
        mergeSort(arr);
        System.out.println(Arrays.toString(arr));

        Integer[] arr2 = new Integer[]{3, 2, 7, 4, 8, 6, 1, 7};
        mergeSort(arr2, Integer::compareTo);
        System.out.println(Arrays.toString(arr2));

    }

    public static <E> void mergeSort(E[] list,
                                     Comparator<? super E> comparator) {
        if (list.length > 1) {
            E[] firstHalf = Arrays.copyOf(list, list.length / 2);
            System.arraycopy(list, 0, firstHalf, 0, list.length / 2);
            mergeSort(firstHalf, comparator);

            int secondHalfLength = list.length - list.length / 2;
            E[] secondHalf = Arrays.copyOf(list, secondHalfLength);
            System.arraycopy(list, list.length / 2,
                    secondHalf, 0, secondHalfLength);
            mergeSort(secondHalf, comparator);

            int current1, current2, current3;
            current1 = current2 = current3 = 0;

            while (current1 < firstHalf.length && current2 < secondHalf.length) {
                if (comparator.compare(firstHalf[current1], secondHalf[current2]) < 0)
                    list[current3++] = firstHalf[current1++];
                else
                    list[current3++] = secondHalf[current2++];
            }

            while (current1 < firstHalf.length)
                list[current3++] = firstHalf[current1++];

            while (current2 < secondHalf.length)
                list[current3++] = secondHalf[current2++];
        }
    }


    public static <E extends Comparable<E>> void mergeSort(E[] list) {
        if (list.length > 1) {

            E[] firstHalf = Arrays.copyOf(list, list.length / 2);
            System.arraycopy(list, 0, firstHalf, 0, list.length / 2);
            mergeSort(firstHalf);

            int secondHalfLength = list.length - list.length / 2;
            E[] secondHalf = Arrays.copyOf(list, secondHalfLength);
            System.arraycopy(list, list.length / 2,
                    secondHalf, 0, secondHalfLength);
            mergeSort(secondHalf);

            int current1, current2, current3;
            current1 = current2 = current3 = 0;

            while (current1 < firstHalf.length && current2 < secondHalf.length) {
                if (firstHalf[current1].compareTo(secondHalf[current2]) < 0)
                    list[current3++] = firstHalf[current1++];
                else
                    list[current3++] = secondHalf[current2++];
            }

            while (current1 < firstHalf.length)
                list[current3++] = firstHalf[current1++];

            while (current2 < secondHalf.length)
                list[current3++] = secondHalf[current2++];
        }
    }

}
