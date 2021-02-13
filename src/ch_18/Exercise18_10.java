package ch_18;

import java.util.Scanner;

/**
 * *18.10 (Occurrences of a specified character in a string) Write a recursive method that
 * finds the number of occurrences of a specified letter in a string using the following method header:
 * public static int count(String str, char a)
 * <p>
 * For example, count("Welcome", 'e') returns 2.
 * <p>
 * Write a test program that prompts the user to enter a string and a character, and displays the number of
 * occurrences for the character in the string.
 */
public class Exercise18_10 {
    static int count;

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.print("Enter a String and a character to count it's occurrences:");
        String str = in.next();
        char ch = in.next().charAt(0);

        System.out.println("Character " + ch + " occurs " + count(str, ch) + " times in " + str);
        in.close();
    }

    public static int count(String str, char a) {
        if (str.length() > 0) {
            if (str.charAt(str.length() - 1) == a) {
                return 1 + count(str.substring(0, str.length() - 1), a);
            } else {
                return count(str.substring(0, str.length() - 1), a);
            }
        }
        return 0;

    }
}
