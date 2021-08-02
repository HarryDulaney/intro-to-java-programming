package ch_13;

import java.util.ArrayList;
import java.util.Random;

/**
 * 13.2 (Shuffle ArrayList) Write the following method that shuffles an ArrayList of
 * numbers:
 * public static void shuffle(ArrayList<Number> list)
 */
public class Exercise13_02 {
    static ArrayList<Number> testList;

    public static void main(String[] args) {
        testList = new ArrayList<>();

        for (int i = 0; i < 100; i++) {
            testList.add(i);
        }
        System.out.println("Original list of random int Numbers: ");
        System.out.println(testList.toString());

        System.out.println("Shuffling the list....");
        shuffle(testList);

        System.out.println("Shuffle completed: ");
        System.out.println(testList.toString());

        testShuffled(testList);

    }

    public static void shuffle(ArrayList<Number> list) {
        for (int i = 0; i < list.size(); i++) {
            int randIdx = new Random().nextInt(99);
            Number numberFromCurrIdx = list.get(i);
            Number randomRemovedNumber = list.get(randIdx);
            //Swap Numbers
            list.set(i, randomRemovedNumber);
            list.set(randIdx, numberFromCurrIdx);
        }
    }

    static void testShuffled(ArrayList<Number> list) {
        System.out.println("Testing shuffled list contains same contents as original list....");
        ArrayList<Number> copyOfShuffledList = new ArrayList<>(list);
        copyOfShuffledList.sort((o1, o2) -> {
            if (o1.intValue() == o2.intValue()) return 0;
            return o1.intValue() > o2.intValue() ? 1 : -1;
        });
        boolean equalSortedArray = true;
        int i = 0;
        for (; i < 100; i++) {
            if (i != copyOfShuffledList.get(i).intValue()) {
                equalSortedArray = false;
                break;
            }
        }
        if (!equalSortedArray) System.out.println("Shuffled array does not have same contents as original, @see array" +
                " index: " + i);
        else System.out.println("Shuffled array has same contents as original array: " + equalSortedArray);
    }
}
