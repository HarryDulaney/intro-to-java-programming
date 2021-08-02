package ch_18;

import java.util.Scanner;

/**
 * 18.21 (Decimal to binary) Write a recursive method that converts a decimal number
 * into a binary number as a string. The method header is:
 * public static String dec2Bin(int value)
 * Write a test program that prompts the user to enter a decimal number and displays its binary equivalent.
 */
public class Exercise18_21 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.print("Enter a decimal(base 10) number as an integer: ");
        int decValue = in.nextInt();
        System.out.println(decValue + " converted to binary is: " + dec2Bin(decValue));

        in.close();
    }

    public static String dec2Bin(int value) {
        return dec2Bin(value, "");
    }


    static String dec2Bin(int value, String binary) {
        if (value > 0) {
            return dec2Bin(value / 2, (value % 2) + binary);
        }
        return binary;
    }
}
