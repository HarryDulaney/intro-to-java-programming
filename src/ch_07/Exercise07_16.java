package ch_07;

import java.util.Arrays;

/**
 * 7.16 (Execution time) Write a program that randomly generates an array of 100,000
 * integers and a key.
 * <p>
 * 1.) Estimate the execution time of invoking the linearSearch
 * method in Listing 7.6.
 * <p>
 * 2.) Sort the array and estimate the execution time of invoking
 * the binarySearch method in Listing 7.7. You can use the following code
 * template to obtain the execution time:
 * <p>
 * long startTime = System.currentTimeMillis();
 * perform the task;
 * long endTime = System.currentTimeMillis();
 * long executionTime = endTime - startTime;
 *
 * @author HG Dulaney
 */
public class Exercise07_16 {

    /**
     * @param list of int values to pull a random number from
     */
    static int assignRandomKey(int[] list) {
        return list[(int) (1 + Math.random() * 99_999)];
    }

    public static void main(String[] args) {

        int[] randoms = generateArrayOfRandomCharacters(100_000);
        assignRandomKey(randoms);// Helper function new random key value
        int searchKeyRandom;
        // Estimate exe. time of linearSearch
        searchKeyRandom = assignRandomKey(randoms);
        long startTime = System.currentTimeMillis();

        int linSearRes = linearSearch(randoms, searchKeyRandom);
        long executionTime = System.currentTimeMillis() - startTime;

        System.out.println("Linear search took: " + executionTime + " ms");
        System.out.println("The method returned index# : " + linSearRes);
        System.out.println("Search key was " + searchKeyRandom + " and value at index# " + linSearRes + " is " + randoms[linSearRes]);
        System.out.println();

        //Estimate exe. time of binarySearch
        //Sort array (Low to High, for Binary Search to work)
        Arrays.sort(randoms);
        assignRandomKey(randoms); //Helper function, new random key value
        long startTime2 = System.currentTimeMillis();

        searchKeyRandom = assignRandomKey(randoms);

        int biSearRes = binarySearch(randoms, searchKeyRandom);
        long endtime2 = System.currentTimeMillis();
        long executionTime2 = endtime2 - startTime2;
        System.out.println("\nBinary search took " + executionTime2 + " ms");
        System.out.println(" The method returned index# : " + biSearRes);
        System.out.println("Search key was " + searchKeyRandom + " and value at index# " + biSearRes + " is " + randoms[biSearRes]);
        printArray(randoms);//Helper to print array
    }

    private static int[] generateArrayOfRandomCharacters(int len) {
        int[] res = new int[len];
        for (int i = 0; i < res.length; i++) {
            res[i] = (int) (1 + Math.random() * 1_000_000); //Random integers between 1 and 1,000,000
        }
        return res;
    }

    /**
     * From Listing 7.9
     * Use binary search to find the key in the list
     */
    public static int binarySearch(int[] list, int key) {
        int low = 0;
        int high = list.length - 1;
        while (high >= low) {
            int mid = (low + high) / 2;
            if (key < list[mid])
                high = mid - 1;
            else if (key == list[mid])
                return mid;
            else
                low = mid + 1;
        }
        return (low * -1) - 1; /* Now high < low, key not found */
    }

    /**
     * From Listing 7.6
     * The method for finding a key in the list
     */
    public static int linearSearch(int[] list, int key) {
        for (int i = 0; i < list.length; i++) {
            if (key == list[i])
                return i;
        }
        return -1;
    }

    static void printArray(int[] array) {
        for (int i = 0; i < 1000; i++) {
            System.out.print(array[i] + " ");
            if (i % 20 == 0) {
                System.out.println();
            }

        }
        System.out.println("..........");
    }
}
