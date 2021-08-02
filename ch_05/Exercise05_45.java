package ch_05;

import java.util.Scanner;

/**
 * **5.45 (Statistics: compute mean and standard deviation) In business applications, you
 * are often asked to compute the mean and standard deviation of data. The mean is
 * simply the average of the numbers. The standard deviation is a statistic that tells
 * you how tightly all the various data are clustered around the mean in a set of data.
 * For example, what is the average age of the students in a class? How close are the
 * ages? If all the students are the same age, the deviation is 0.
 * Write a program that prompts the user to enter ten numbers, and displays the
 * mean and standard deviations of these numbers using the following formula:
 * <p>
 * Here is a sample run:
 * Enter ten numbers: 1 2 3 4.5 5.6 6 7 8 9 10
 * The mean is 5.61
 * The standard deviation is 2.99794
 */
public class Exercise05_45 {
    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);
        System.out.println("Enter 10 numbers: ");
        double mean, std = 0, sum = 0;

        double[] nums = new double[10];

        for (int i = 0; i < nums.length; i++) {
            nums[i] = in.nextDouble();
        }
        for (double num : nums) {
            sum += num;
        }

        mean = sum / 10;
        System.out.println("The mean is " + mean);

        double temp = 0;

        for (double num : nums) {
            temp += Math.pow(num - mean, 2);
        }
        std = Math.sqrt(temp / 9); // n-1

        System.out.printf("The standard deviation is %.5f", std);
    }


}
