package ch_07;

import java.util.Scanner;

/**
 * 7.8 (Average an array) Write two overloaded methods that return the average
 * of an array with the following headers:
 * public static int average(int[] array)
 * public static double average(double[] array)
 * Write a test program that prompts the user to enter ten double values,
 * invokes this method, and displays the average value.
 *
 * @author Harry Dulaney
 */
public class Exercise07_08 {
    public static int average(int[] array) {
        int elemInArray = array.length;
        int sum = 0;

        for (int i = 0; i < elemInArray; i++) {
            sum += array[i];
        }

        return sum / elemInArray;
    }

    public static double average(double[] array) {

        int elemInArray = array.length;
        double sum = 0;
        for (int i = 0; i < elemInArray; i++) {
            sum += array[i];

        }
        double average = sum / elemInArray;
        return average;

    }

    public static void main(String[] args) {
        double[] values = new double[10];
        Scanner input = new Scanner(System.in);
        System.out.println("Please enter ten double values: ");

        for (int i = 0; i < 10; i++) {
            values[i] = input.nextDouble();
        }
        double toPrint = average(values);
        System.out.println(toPrint);
    }
}
