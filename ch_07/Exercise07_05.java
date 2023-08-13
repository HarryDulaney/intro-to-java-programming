package ch_07;

import java.util.HashSet;
import java.util.Scanner;

/**
 * 7.5 (Print distinct numbers) Write a program that reads in ten numbers and
 * displays the number of distinct numbers and the distinct numbers in their
 * input order and separated by exactly one space (i.e., if a number appears
 * multiple times, it is displayed only once). (Hint: Read a number and store
 * it to an array if it is new. If the number is already in the array, ignore
 * it.)
 * After the input, the array contains the distinct numbers.
 */
public class Exercise07_05 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        HashSet<Integer> DistinctAraay = new HashSet<>();
        System.out.println("enter numbers:");
        for (int i = 0; i < 10; i++) {
            int number = input.nextInt();
            DistinctAraay.add(number);

        }
        input.close();
        System.out.println("number of distinct numbers is: " + DistinctAraay.size());
        System.out.println("numbers are:");

        for (int number : DistinctAraay) {
            System.out.print(number + " ");

        }

    }

}