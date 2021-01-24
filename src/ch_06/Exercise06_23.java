package ch_06;

import java.util.*;

/**
 * *6.23 (Occurrences of a specified character) Write a method that finds the number of
 * occurrences of a specified character in a string using the following header:
 * public static int count(String str, char a)
 * For example, count("Welcome", 'e') returns 2.
 * <p>
 * Write a test program that
 * prompts the user to enter a string followed by a character and displays the number
 * of occurrences of the character in the string.
 */
public class Exercise06_23 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.print("Enter a string followed by a character: ");
        String s = in.nextLine();
        char c = s.charAt(s.length() - 1);
        s = s.substring(0, s.length() - 1);
        s = s.trim();

        System.out.println("The character " + c + " occurs " + count(s, c) + " times in " + s);

    }

    public static int count(String str, char a) {
        int count = 0;
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == a) {
                count++;
            }
        }
        return count;
    }
}