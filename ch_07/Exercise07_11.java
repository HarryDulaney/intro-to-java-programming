package ch_07;

import java.util.*;

/**
 * *7.11 (Statistics: compute deviation) Programming Exercise 5.45 computes the standard deviation of numbers.
 * This exercise uses a different but equivalent formula to
 * compute the standard deviation of n numbers.
 * <p>
 * Enter ten numbers: 1.9 2.5 3.7 2 1 6 3 4 5 2
 * The mean is 3.11
 * The standard deviation is 1.55738
 * To compute the standard deviation with this formula, you have to store the individual numbers using an array, so that they can be used after the mean is obtained.
 * Your program should contain the following methods:
 * /** Compute the deviation of double values
 * <p>
 * public static double deviation(double[]x)
 * /** Compute the mean of an array of double values
 * public static double mean(double[]x)
 * <p>
 * Write a test program that prompts the user to enter ten numbers and displays the
 * mean and standard deviation,as shown in the following sample run:
 */
public class Exercise07_11 {
    static double mean;

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        double[] nums = new double[10];
        System.out.print("Enter 10 numbers: ");
        for (int i = 0; i < nums.length; i++) {
            nums[i] = in.nextDouble();
        }
        mean = mean(nums);
        double std = deviation(nums);

        System.out.printf("The mean is %.2f" + "\n", mean);
        System.out.printf("The standard deviation is %.5f", std);
    }

    public static double deviation(double[] x) {
        double numerator = 0.0;
        double denominator = x.length - 1;
        for (double d : x) {
            numerator += Math.pow((d - mean), 2);
        }
        return Math.sqrt((numerator / denominator));

    }

    public static double mean(double[] x) {
        double sum = 0;
        double total = x.length;
        for (double d : x) {
            sum += d;
        }
        return sum / total;

    }
}