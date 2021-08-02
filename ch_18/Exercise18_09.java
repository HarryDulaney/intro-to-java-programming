package ch_18;

import java.util.Scanner;

/**
 * *18.9 (Print the characters in a string reversely)
 * Write a recursive method that displays a string reversely on the console using the following header:
 * public static void reverseDisplay(String value)
 * <p>
 * For example, reverseDisplay("abcd") displays dcba. Write a test program
 * that prompts the user to enter a string and displays its reversal.
 */
public class Exercise18_09 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.print("Enter a string to reverse: ");
        String s = in.nextLine().trim();
        reverseDisplay(s);
        in.close();
    }

    public static void reverseDisplay(String value) {
        if (!(value.length() == 0)) {
            System.out.print(value.charAt(value.length() - 1));
            reverseDisplay(value.substring(0, value.length() - 1));
        }

    }
}
