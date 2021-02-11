package ch_18;

import java.util.Scanner;

/**
 * *18.8 (Print the digits in an integer reversely) Write a recursive method that displays
 * an int value reversely on the console using the following header:
 * <p>
 * public static void reverseDisplay(int value)
 * For example, reverseDisplay(12345) displays 54321. Write a test program
 * that prompts the user to enter an integer and displays its reversal.
 */
public class Exercise18_08 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.print("Enter an integer to reverse: ");
        int num = in.nextInt();
        reverseDisplay(num);
        in.close();
    }

    public static void reverseDisplay(int value) {
        if (value > 0) {
            System.out.print(value % 10);
            reverseDisplay(value / 10);
        }

    }
}
