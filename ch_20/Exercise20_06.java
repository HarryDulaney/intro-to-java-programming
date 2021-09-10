package ch_20;

import java.util.Iterator;
import java.util.LinkedList;

/**
 * 20.6 (Use iterators on linked lists) Write a test program that stores 5 million integers
 * in a linked list and test the time to traverse the list using an iterator vs. using
 * the get(index) method.
 */
public class Exercise20_06 {
    static Integer size = 5_000_000;
    private static final boolean PRINT_TEST = false;

    public static void main(String[] args) {
        LinkedList<Integer> testList = new LinkedList<>();

        for (int i = 0; i < size; i++) {
            testList.add(i);
        }
        System.out.println("Start Iterator test...");
        double time1 = testIterator(testList);
        System.out.println("\nIterator completed in " + time1 + " seconds.");

        System.out.println("Start get method iteration test...");
        double time2 = testGetMethod(testList);
        System.out.println("\nGet method iteration completed in " + time2 + " seconds.");

    }

    static double testIterator(LinkedList<Integer> list) {
        Iterator<Integer> listIterator = list.iterator();
        long startTime = System.currentTimeMillis();
        while (listIterator.hasNext()) {
            Integer i = listIterator.next();
            if (PRINT_TEST) {
                System.out.println(i + " ");
            }
        }

        long endTime = System.currentTimeMillis();
        long time = endTime - startTime;

        return time / 1000.00;
    }

    static double testGetMethod(LinkedList<Integer> list) {
        long startTime = System.currentTimeMillis();
        for (int i = 0; i < list.size(); i++) {
            Integer j = list.get(i);
            if (PRINT_TEST) {
                System.out.println(j + " ");
            }
        }

        long endTime = System.currentTimeMillis();
        long time = endTime - startTime;

        return time / 1000.00;
    }
}
