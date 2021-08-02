package ch_18;

import java.util.Scanner;

/**
 * *18.17 (Occurrences of a specified character in an array) Write a recursive method that
 * finds the number of occurrences of a specified character in an array. You need to
 * define the following two methods. The second one is a recursive helper method.
 * public static int count(char[] chars, char ch)
 * public static int count(char[] chars, char ch, int high)
 * Write a test program that prompts the user to enter a list of characters in one line,
 * and a character, and displays the number of occurrences of the character in the list.
 */
public class Exercise18_17 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.print("Enter a list of characters in one line: ");
        String line = in.nextLine();
        char[] chars = line.toCharArray();

        System.out.println("Enter a single character: ");
        char ch = in.next().charAt(0);
        System.out.println("The character " + ch + " occurs " + count(chars, ch) + " times.");
        in.close();
    }

    public static int count(char[] chars, char ch) {
        return count(chars, ch, chars.length - 1);
    }

    public static int count(char[] chars, char ch, int high) {
        if (high > 0) {
            return chars[high] == ch ? (1 + count(chars, ch, high - 1)) : (count(chars, ch, high - 1));
        } else {
            return 0;
        }
    }
}
