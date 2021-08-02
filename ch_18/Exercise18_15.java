package ch_18;

import java.util.Scanner;

/**
 * *18.15 (Occurrences of a specified character in a string) Rewrite Programming Exercise 18.10 using a helper
 * method to pass the substring high index to the method.
 * The helper method header is:
 * public static int count(String str, char a, int high)
 */
public class Exercise18_15 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.print("Enter a String and a character to count it's occurrences:");
        String str = in.next();
        char ch = in.next().charAt(0);

        System.out.println("Character " + ch + " occurs " + count(str, ch) + " times in " + str);
        in.close();
    }

    public static int count(String str, char a, int high) {
        if (high > 0) {
            return str.charAt(high) == a ? (1 + count(str, a, high - 1)) : (count(str, a, high - 1));
        } else {
            return 0;
        }
    }

    public static int count(String str, char a) {
        return count(str, a, str.length() - 1);
    }
}
