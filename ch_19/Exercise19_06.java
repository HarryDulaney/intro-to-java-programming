package ch_19;

import java.util.Arrays;

/**
 * 19.6 (Maximum element in a two-dimensional array) Write a generic method that
 * returns the maximum element in a two-dimensional array.
 * public static <E extends Comparable<E>> E max(E[][] list)
 */
public class Exercise19_06 {
    public static void main(String[] args) {
        Double[][] values = new Double[][]{
                {100.1, 100.3, 555.12},
                {100.0, 100.8, 100.6},
                {65656.22, 1112.34, 99.9}

        };
        System.out.println("Generic Max method returned: " + max(values) + ". When passed this two-dimensional Array " +
                "of values: ");
        for (Double[] valArray: values) {
            System.out.println(Arrays.toString(valArray));
        }
    }

    public static <E extends Comparable<E>> E max(E[][] list) {
        E maxValue = list[0][0];
        for (int i = 0; i < list.length; i++) {
            for (int j = 0; j < list[i].length; j++) {
                if (list[i][j].compareTo(maxValue) > 0) {
                    maxValue = list[i][j];
                }
            }
        }
        return maxValue;
    }

}
