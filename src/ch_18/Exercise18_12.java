package ch_18;

import java.util.Scanner;

/**
 * **18.12 (Print the characters in a string reversely) Rewrite Programming Exercise 18.9
 * using a helper method to pass the substring high index to the method. The
 * helper method header is:
 * public static void reverseDisplay(String value, int high)
 */
public class Exercise18_12 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println("Enter a String: ");
        String s = in.next().trim();
        reverseDisplay(s, s.length() - 1);
    }

    public static void reverseDisplay(String value, int high) {
        if (!(value.length() == 0)) {
            System.out.print(value.charAt(high));
            value = value.substring(0, high);
            reverseDisplay(value, value.length() - 1);
        }
    }
}
