package ch_19;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * 19.8 (Shuffle ArrayList) Write the following method that shuffles an ArrayList:
 * public static <E> void shuffle(ArrayList<E> list)
 */
public class Exercise19_08 {
    public static void main(String[] args) {
        //Test generic method with Double values
        ArrayList<Double> doubleList =
                new ArrayList<>(Arrays.asList(1.1, 2.2, 3.3, 4.4, 5.5, 6.6, 7.7, 8.8));
        //Test generic method with Integer values
        ArrayList<Integer> integerList =
                new ArrayList<>(Arrays.asList(11, 22, 33, 44, 55, 66, 77, 88));

        System.out.println("Before shuffling the ArrayList of Doubles is: " + doubleList);
        shuffle(doubleList);
        System.out.println("After performing Generic shuffle: " + doubleList);

        System.out.println("Before shuffling the ArrayList of Integers is: " + integerList);
        shuffle(integerList);
        System.out.println("After performing Generic shuffle: " + integerList);
    }

    public static <E> void shuffle(ArrayList<E> list) {
        for (int i = 0; i < list.size() && !list.isEmpty(); i++) { // Loop through ArrayList
            int randomIdx = (int) (Math.random() * (list.size() - 1));
            // Swap random values
            E value = list.get(i); // Get value in array at index i
            E temp = list.get(randomIdx); // Get value at random index
            list.set(randomIdx, value); // Set value to randomIdx
            list.set(i, temp); // Set value from randomIdx to index i
        }
    }
}
