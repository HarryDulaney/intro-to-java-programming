package ch_13;

import java.util.ArrayList;
import java.util.Random;

/**
 * 13.3 (Sort ArrayList) Write the following method that sorts an ArrayList of numbers.
 * public static void sort(ArrayList<Number> list)
 */
public class Exercise13_03 {
    static ArrayList<Number> testList;

    public static void main(String[] args) {
        testList = new ArrayList<>();
        Random random = new Random();

        for (int i = 0; i < 100; i++) {
            testList.add(random.nextInt(100));
        }
        System.out.println("Original list of random int Numbers: ");
        System.out.println(testList.toString());

        System.out.println("Sorting the list...");
        sort(testList);

        System.out.println("Sorted list of int Numbers: ");
        System.out.println(testList.toString());

        System.out.println("Checking list is correctly sorted....");
        System.out.println("Is list correctly sorted: " + isArraySorted(testList));
    }

    public static void sort(ArrayList<Number> list) {
        boolean isSorted = false;
        while (!isSorted) {
            isSorted = true;
            for (int i = 0; i < list.size() - 1; i++) {
                if (list.get(i).intValue() > list.get(i + 1).intValue()) {
                    isSorted = false;
                    Number smallNum = list.get(i + 1);
                    list.set(i + 1, list.get(i));
                    list.set(i, smallNum);
                }
            }
        }
    }

    static boolean isArraySorted(ArrayList<Number> list) {
        for (int i = 1; i < list.size(); i++) {
            if (list.get(i).intValue() < list.get(i - 1).intValue()) {
                return false;
            }
        }
        return true;
    }
}