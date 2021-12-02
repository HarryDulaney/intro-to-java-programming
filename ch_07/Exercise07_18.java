package ch_07;

import java.util.Scanner;

/**
 * 7.18 (Bubble sort) Write a sort method that uses the bubble-sort algorithm.
 * The bubble-sort algorithm makes several passes through the array.
 * On each pass, successive neighboring pairs are compared. If a pair is not in
 * order, its values are swapped; otherwise, the values remain unchanged.
 * The technique is called a bubble sort or sinking sort because the
 * smaller values gradually “bubble” their way to the top and the larger
 * values “sink” to the bottom. Write a test program that reads in ten
 * double numbers, invokes the method, and displays the sorted numbers.
 * <p>
 * Example:  Enter ten decimal numbers: 751.015 111.122 65.991 751.001 577.772 111.231 500.100 753.613 375.846 111.321
 *
 * @author Harry D.
 */
public class Exercise07_18 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        double[] numbers = new double[10];
        System.out.print("Enter ten decimal numbers:");

        for (int i = 0; i < numbers.length; i++) {
            numbers[i] = input.nextDouble();
        }

        bubbleSort(numbers);

        for (int i = 0; i < numbers.length; i++)
            System.out.print(numbers[i] + " ");
    }

    public static void bubbleSort(double[] arr) {
        double temp;
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr.length - i - 1; j++) {
                if (arr[j] > arr[j + 1]) {
                    temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;

                }
            }
        }
    }
}
