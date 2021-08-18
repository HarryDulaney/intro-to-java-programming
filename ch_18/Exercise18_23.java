package ch_18;

import java.util.Scanner;

/**
 * 18.23 (Binary to decimal) Write a recursive method that parses a binary number as a
 * string into a decimal integer.
 * The method header is:
 * public static int bin2Dec(String binaryString)
 * <p>
 * Write a test program that prompts the user to enter a binary string and displays
 * its decimal equivalent.
 */
public class Exercise18_23 {
    static int pow = 0;
    static int decimal;

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.print("Enter the binary number to convert to decimal: ");
        String binaryNum = in.next();
        System.out.println(binaryNum + " binary number is equivalent to the decimal integer: " + bin2Dec(binaryNum));
        in.close();

    }


    public static int bin2Dec(String binaryString) {
        if (binaryString.length() == 0) {
            return decimal;
        }
        char binaryDigit = binaryString.charAt(binaryString.length() - 1);
        int binaryValue = Integer.parseInt(binaryDigit + "");
        decimal += binaryValue * ((int) Math.pow(2, pow));
        pow += 1;
        return bin2Dec(binaryString.substring(0, binaryString.length() - 1));

    }
}
