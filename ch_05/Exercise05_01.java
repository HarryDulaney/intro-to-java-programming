package ch_05;

import java.util.Scanner;

/**
 * 5.1 (Count positive and negative numbers and
 * compute the average of numbers) Write a program that reads an
 * unspecified number of integers, determines how many positive
 * and negative values have been read, and computes the total and average
 * of the input values (not counting zeros). Your program ends with the input 0.
 * Display the average as a floating-point number.
 * If your entire input is 0, the program displays No numbers are entered except 0.
 */
public class Exercise05_01 {
    public static void main(String[] args) {

        double total = 0;
        int pos = 0;
        int neg = 0;

        Scanner input = new Scanner(System.in);

        System.out.println("Enter any integer, positive "
                + "or negative (the program ends when you enter 0): ");


        int number = input.nextInt();

        if (number == 0) {
            System.out.println("No numbers entered except 0");
            System.exit(1);
        }

        int count = 0;

        while (number != 0) {

            total += number;
            count++;

            if (number > 0) {
                pos++;
            }
            if (number < 0) {
                neg++;
            }

            number = input.nextInt();
        }

        double average = total / count;

        System.out.println("The number of positives is: " + pos);
        System.out.println("The number of negatives is: " + neg);
        System.out.println("The total is: " + total);
        System.out.println("The average is: " + average);
    }

}