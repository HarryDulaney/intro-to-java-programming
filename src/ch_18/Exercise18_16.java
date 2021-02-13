package ch_18;

import java.util.Scanner;

/**
 * *18.16 (Find the number of uppercase letters in an array) Write a recursive method
 * to return the number of uppercase letters in an array of characters. You need to
 * define the following two methods. The second one is a recursive helper method.
 * public static int count(char[] chars)
 * public static int count(char[] chars, int high)
 * Write a test program that prompts the user to enter a list of characters in one line
 * and displays the number of uppercase letters in the list.
 */
public class Exercise18_16 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.print("Enter a list of characters in one line: ");

        String line = in.nextLine();
        char[] chars = line.toCharArray();

        System.out.println("The number of uppercase letters in the list is: " + count(chars));
        in.close();
    }

    public static int count(char[] chars) {
        return count(chars, chars.length - 1);
    }

    public static int count(char[] chars, int high) {
        if (high > 0) {
            return Character.isUpperCase(chars[high]) ? (1 + count(chars, high - 1)) : (count(chars, high - 1));
        } else {
            return 0;
        }

    }
}
