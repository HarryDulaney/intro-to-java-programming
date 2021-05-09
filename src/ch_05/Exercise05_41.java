package ch_05;

import java.util.Scanner;

/**
 * 5.41 (Occurrence of max numbers) Write a program that reads integers, finds the
 * largest of them, and counts its occurrences. Assume that the input ends with
 * number 0. Suppose that you entered 3 5 2 5 5 5 0; the program
 * finds that the largest is 5 and the occurrence count for 5 is 4.
 */
public class Exercise05_41 {
    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        int max = 0;
        int count = 0;
        int numStart = 0;

        do {
            System.out.println("Enter an integer (0 ends the input): ");

            numStart = input.nextInt();

            if (numStart > max) {
                count = 1;
                max = numStart;
                continue;
            }
            if (numStart == max) {
                count++;
            }

        } while (numStart != 0);

        System.out.println("Max is: " + max + "\nThe count for max is: " + count);
    }
}