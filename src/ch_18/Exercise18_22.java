package ch_18;

import java.util.Scanner;

/**
 * 18.22 (Decimal to hex) Write a recursive method that converts a decimal number into
 * a hex number as a string. The method header is:
 * public static String dec2Hex(int value)
 * <p>
 * <p>
 * Write a test program that prompts the user to enter a decimal number and displays its hex equivalent
 */
public class Exercise18_22 {
    static String hexValue = "";

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.print("Enter a decimal number to convert to hex: ");
        int number = in.nextInt();

        System.out.println(number + " is equivalent to hexadecimal number " + dec2Hex(number));
        in.close();
    }

    public static String dec2Hex(int value) {
        if (value < 16) {
            return getAsHexNumber(value) + hexValue;
        }
        hexValue = getAsHexNumber(value % 16) + hexValue;
        return dec2Hex(value / 16);

    }

    static String getAsHexNumber(int value) {
        switch (value) {
            case 10:
                return "A";
            case 11:
                return "B";
            case 12:
                return "C";
            case 13:
                return "D";
            case 14:
                return "E";
            case 15:
                return "F";
            default:
                return String.valueOf(value);
        }


    }
}
