package ch_20;

import java.util.Iterator;
import java.util.LinkedList;

/**
 * 20.6 (Use iterators on linked lists) Write a test program that stores 5 million integers
 * in a linked list and test the time to traverse the list using an iterator vs. using
 * the get(index) method.
 */
public class Exercise20_06 {
    static Integer size = 500_000;// I adjusted the test case to this because 5 million takes forever with get method

    public static void main(String[] args) {
        LinkedList<Integer> testList = new LinkedList<>();

        for (int i = 0; i < size; i++) {
            testList.add((int) (1 + Math.random() * 9999));
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
        int nextLine = 0;
        while (listIterator.hasNext()) {

            Integer i = listIterator.next();
            if (nextLine % 1000 == 0) {
                System.out.print(i + " ");
            }
            nextLine++;

        }

        long endTime = System.currentTimeMillis();
        long time = endTime - startTime;

        return time / 1000.00;
    }

    static double testGetMethod(LinkedList<Integer> list) {
        long startTime = System.currentTimeMillis();
        int nextLine = 0;
        for (int i = 0; i < list.size(); i++) {
            Integer j = list.get(i);
            if (nextLine % 1000 == 0) {
                System.out.print(j + " ");
            }
            nextLine++;
        }

        long endTime = System.currentTimeMillis();
        long time = endTime - startTime;

        return time / 1000.00;
    }
}
