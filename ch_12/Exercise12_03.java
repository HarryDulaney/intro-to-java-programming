package ch_12;

import java.util.Scanner;

/**
 * 12.3 (ArrayIndexOutOfBoundsException) Write a program that meets the following requirements:
 * Creates an array with 100 randomly chosen integers
 * Prompts the user to enter the index of the array, then displays the corresponding element value.
 * If the specified index is out of bounds, display the message Out of Bounds.
 */
public class Exercise12_03 {
    public static void main(String[] args) {

        int[] randomArray = new int[100];

        for (int i = 0; i < randomArray.length; i++) {
            randomArray[i] = (int) (1 + Math.random() * 10_000);
        }

        Scanner input = new Scanner(System.in);

        System.out.println("Enter an index in the array for which to display it's value: ");

        try {
            int indexValue = input.nextInt();
            System.out.println(randomArray[indexValue]);

        } catch (ArrayIndexOutOfBoundsException ex) {
            System.out.println("Out Of Bounds");
        }

        input.close();
    }

}
