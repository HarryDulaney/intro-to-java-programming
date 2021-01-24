package ch_06;

import java.util.Scanner;

/**
 * *6.20 (Count the letters in a string) Write a method that counts the number of letters in
 * a string using the following header:
 * public static int countLetters(String s)
 * Write a test program that prompts the user to enter a string and displays the number of letters in the string.
 *
 * @author Harry D.
 */
public class Exercise06_20 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println("Enter a string:");
        String s = in.next();
        System.out.println("Number of letters: " + countLetters(s));
        in.close();
    }

    public static int countLetters(String s) {
        int count = 0;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (Character.isLetter(c)) {
                count++;
            }
        }
        return count;
    }

}
