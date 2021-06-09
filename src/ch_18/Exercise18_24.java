package ch_18;

import java.util.Scanner;

/**
 * *18.24 (Hex to decimal) Write a recursive method that parses a hex number as a string
 * into a decimal integer.
 * <p>
 * The method header is:
 * public static int hex2Dec(String hexString)
 * Write a test program that prompts the user to enter a hex string and displays its
 * decimal equivalent.
 */
public class Exercise18_24 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter a hex number: ");
        String hex = input.nextLine();
        System.out.println(hex + " is decimal " + hex2Dec(hex));
    }

    public static long hex2Dec(String hexString) {
        return hex2Dec(hexString, 0, hexString.length() - 1);
    }

    public static long hex2Dec(String hexString, int low, int high) {
        if (high < low)
            return 0;
        else {
            return hex2Dec(hexString, low, high - 1) * 16
                    + hexCharToDecimal(hexString.charAt(high));
        }
    }

    public static long hexCharToDecimal(char ch) {
        if ('A' <= ch && ch <= 'F')
            return 10 + ch - 'A';
        else
            return ch - '0';
    }
}
