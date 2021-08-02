package ch_09.exercise09_06;

import java.util.Random;

/**
 * 9.6 (Stopwatch) Design a class named StopWatch. The class contains:
 * ■ Private data fields startTime and endTime with getter methods.
 * ■ A no-arg constructor that initializes startTime with the current time.
 * ■ A method named start() that resets the startTime to the current time.
 * ■ A method named stop() that sets the endTime to the current time.
 * ■ A method named getElapsedTime() that returns the elapsed time for the
 * stopwatch in milliseconds.
 * <p>
 * Draw the UML diagram for the class and then implement the class.
 * <p>
 * Write a test program that measures the execution time of sorting 100,000 numbers
 * using selection sort.
 */
public class Exercise09_06 {
    public static void main(String[] args) {
        int[] testNums = new int[100000];
        Random random = new Random();

        for (int i = 0; i < 100000; i++) {
            testNums[i] = random.nextInt(10000);
        }
        StopWatch stopWatch = new StopWatch();
        stopWatch.start();
        System.out.println("Start time: " + stopWatch.getStartTime() + " ms");

        selectionSort(testNums);
        stopWatch.stop();

        System.out.println("End time: " + stopWatch.getEndTime() + " ms");

        System.out.println("Elapsed time for selection sort: " + stopWatch.getElapsedTime() + " ms");


    }

    public static void selectionSort(int[] nums) {
        for (int n = 0; n < nums.length - 1; n++) {
            int min = nums[n];
            int minIdx = n;
            for (int k = n + 1; k < nums.length; k++) {
                if (nums[k] < min) {
                    min = nums[k];
                    minIdx = k;
                }
            }
            // Swap
            if (minIdx != n) {
                nums[minIdx] = nums[n];
                nums[n] = min;
            }
        }
    }
}
