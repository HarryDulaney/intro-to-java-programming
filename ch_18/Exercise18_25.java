package ch_18;

import java.util.Scanner;

/**
 * *18.25 (String permutation) Write a recursive method to print all the permutations of a
 * string.
 * <p>
 * For example, for the string abc, the permutation is
 * abc
 * acb
 * bac
 * bca
 * cab
 * cba
 * (Hint: Define the following two methods. The second is a helper method.)
 * public static void displayPermutation(String s)
 * public static void displayPermutation(String s1, String s2)
 * <p>
 * The first method simply invokes displayPermutation(" ", s). The second
 * method uses a loop to move a character from s2 to s1 and recursively invokes
 * it with a new s1 and s2. The base case is that s2 is empty and prints s1 to the
 * console.
 * <p>
 * Write a test program that prompts the user to enter a string and displays all its
 * permutations.
 */
public class Exercise18_25 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.print("Enter a string: ");
        String input = in.next();
        in.close();

        displayPermutation(input);
    }

    public static void displayPermutation(String s) {
        displayPermutation(" ", s);
    }

    public static void displayPermutation(String s1, String s2) {
        if (s2.length() > 0) {
            for (int i = 0; i < s2.length(); i++) {
                String shuffle1 = s1 + s2.charAt(i);
                String shuffle2 = s2.substring(0, i) + s2.substring(i + 1);
                displayPermutation(shuffle1, shuffle2);
            }
        } else {
            System.out.println(s1);
        }
    }
}
